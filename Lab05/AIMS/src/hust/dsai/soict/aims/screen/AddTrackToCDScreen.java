package hust.dsai.soict.aims.screen;

import hust.dsai.soict.aims.media.Track;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddTrackToCDScreen extends BaseFrame{
    private ArrayList<Track> ds;
    public AddTrackToCDScreen(ArrayList<Track> ds,Store store,Cart cart){
        super(store, cart);
        this.ds = ds;
        this.setTitle("addTrack");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1024,768);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createSouth(), BorderLayout.SOUTH);

        setVisible(true);
    }
    JTextField fTitle = new JTextField(30);
    JTextField fLength = new JTextField(30);
    JLabel title = new JLabel("Title:");
    JLabel length = new JLabel("Length:");

    JPanel createCenter(){

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        length.setFont(new Font(length.getFont().getName(), Font.PLAIN, 20));
        center.add(title);
        center.add(fTitle);
        center.add(length);
        center.add(fLength);
        return center;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add book");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addBook);
        addBook.setActionCommand("Add Book");
        addBook.addActionListener(csListener);
        smUpdateStore.add(addDVD);
        addDVD.setActionCommand("Add DVD");
        addDVD.addActionListener(csListener);
        smUpdateStore.add(addCD);
        addCD.setActionCommand("Add CD");
        addCD.addActionListener(csListener);

        menu.add(smUpdateStore);
        JMenuItem viewStore = new JMenuItem("View Store");
        JMenuItem viewCart = new JMenuItem("View Cart");

        menu.add(viewStore);
        viewStore.setActionCommand("View Store");
        viewStore.addActionListener(csListener);
        menu.add(viewCart);
        viewCart.setActionCommand("View Cart");
        viewCart.addActionListener(csListener);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private final ActionListener csListener = e -> {
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lỗi: Chưa có Track nào", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            Object source = e.getSource();
            String lenh = "";
            if (source instanceof javax.swing.AbstractButton) {
                lenh = ((javax.swing.AbstractButton) source).getActionCommand();
            }
            switch (lenh) {
                case "Add Book":
                    new AddBookToStoreScreen(store, cart);
                    this.dispose();
                    break;
                case "Add CD":
                    new AddCDToStoreScreen(store, cart);
                    this.dispose();
                    break;
                case "Add DVD":
                    new AddDVDToStoreScreen(store, cart);
                    this.dispose();
                    break;
                case "View Cart":
                    SwingUtilities.invokeLater(() -> {
                        new CartScreen(cart, store);
                    });
                    this.dispose();
                    break;
                case "Return":
                    this.dispose();
                    break;
                default:
                    new StoreScreen(store, cart);
                    this.dispose();
                    break;
            }
        }
    };

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View Cart");
        cart.addActionListener(csListener);
        cart.setActionCommand("View Cart");
        cart.setPreferredSize(new Dimension(100,50));
        cart.setMaximumSize(new Dimension(100,50));

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createSouth(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton addDVD = new JButton("Thêm Track");
        addDVD.setFont(new Font(addDVD.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(addDVD);
        JButton returnButton = new JButton("Return");
        returnButton.setFont(new Font(returnButton.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(returnButton);
        returnButton.setActionCommand("Return");
        returnButton.addActionListener(csListener);

        addDVD.addActionListener (e -> {
            if (fTitle.getText().isEmpty() || fLength.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không được bỏ trống Title/Length", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else if (!fLength.getText().isEmpty() && !fLength.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Lỗi: Length phải nhập số nguyên ", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String title1 = fTitle.getText();
                int length1 = Integer.parseInt(fLength.getText());
                if(length1 <= 0){
                    JOptionPane.showMessageDialog(this, "Lỗi: Length phải > 0 ", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    Track tmp = new Track(title1, length1);
                    Track tmp1 = null;
                    for(Track i : ds){
                        if(i.equals(tmp)){
                            tmp1 = i;
                            break;
                        }
                    }
                    if(tmp1 == null) {
                        ds.add(tmp);
                        JOptionPane.showMessageDialog(this, "Đã thêm Track", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        fTitle.setText("");
                        fLength.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Lỗi: Track đã tồn tại", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                        fTitle.setText("");
                        fLength.setText("");
                    }
                }
            }
        });
        return buttonPanel;
    }
}
