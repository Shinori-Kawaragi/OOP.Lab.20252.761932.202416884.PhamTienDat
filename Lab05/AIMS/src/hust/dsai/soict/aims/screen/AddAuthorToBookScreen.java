package hust.dsai.soict.aims.screen;

import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddAuthorToBookScreen extends BaseFrame{
    ArrayList<String> authors;
    public AddAuthorToBookScreen(ArrayList<String> authors, Cart cart, Store store){
        super(store, cart);
        this.authors = authors;
        this.setTitle("AddAuthor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1024,768);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createSouth(),BorderLayout.SOUTH);
        setVisible(true);
    }

    JLabel author = new JLabel("Author:");
    JTextField fAuthor = new JTextField(30);
    JButton addAuthor = new JButton("Thêm Author");
    JButton returnButton = new JButton("Return");

    JPanel createCenter(){

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        author.setFont(new Font(author.getFont().getName(), Font.PLAIN, 20));
        center.add(author);
        center.add(fAuthor);
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
        if(authors.isEmpty()){
            JOptionPane.showMessageDialog(this, "Lỗi: Chưa có Author", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        returnButton.setFont(new Font(returnButton.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(returnButton);
        returnButton.setActionCommand("Return");
        returnButton.addActionListener(csListener);

        addAuthor.setFont(new Font(addAuthor.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(addAuthor);
        addAuthor.addActionListener (e -> {
            if (fAuthor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không được bỏ trống Author", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String tmp = fAuthor.getText();
                if(authors.contains(tmp)) JOptionPane.showMessageDialog(this, "Đã có tác giả này", "Lỗi", JOptionPane.WARNING_MESSAGE);
                else {
                    authors.add(tmp);
                    JOptionPane.showMessageDialog(this, "Đã thêm tác giả thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                fAuthor.setText("");
            }
        });
        return buttonPanel;
    }
}
