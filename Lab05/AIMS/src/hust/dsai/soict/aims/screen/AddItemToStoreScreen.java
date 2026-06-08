package hust.dsai.soict.aims.screen;

import hust.dsai.soict.aims.media.Media;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends BaseFrame {
    public AddItemToStoreScreen(Store store, Cart cart){
        super(store, cart);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1024,768);
    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
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

    protected final ActionListener csListener = e -> {
        Object source = e.getSource();
        String lenh = "";

        if (source instanceof javax.swing.AbstractButton) {
            lenh = ((javax.swing.AbstractButton) source).getActionCommand();
        }

        switch(lenh) {
            case "Add Book":
                if(this instanceof AddBookToStoreScreen){
                    JOptionPane.showMessageDialog(this, "Bạn đang ở trong giao diện thêm Book", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                new AddBookToStoreScreen(store,cart);
                this.dispose();
                break;
            case "Add CD":
                if(this instanceof AddCDToStoreScreen){
                    JOptionPane.showMessageDialog(this, "Bạn đang ở trong giao diện thêm CD", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                new AddCDToStoreScreen(store,cart);
                this.dispose();
                break;
            case "Add DVD":
                if(this instanceof AddDVDToStoreScreen){
                    JOptionPane.showMessageDialog(this, "Bạn đang ở trong giao diện thêm DVD", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                new AddDVDToStoreScreen(store,cart);
                this.dispose();
                break;
            case "View Cart":
                SwingUtilities.invokeLater(() -> {
                    new CartScreen(cart, store);
                });
                this.dispose();
                break;
            default:
                new StoreScreen(store,cart);
                this.dispose();
                break;
        }
    };
}
