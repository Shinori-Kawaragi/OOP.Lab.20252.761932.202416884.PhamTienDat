package hust.dsai.soict.aims.screen;

import hust.dsai.soict.aims.exception.Quick;
import hust.dsai.soict.aims.media.Book;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    ArrayList<String> authors = new ArrayList<>();
    public AddBookToStoreScreen(Store store, Cart cart){
        super(store, cart);
        Container cp = getContentPane();
        setTitle("AddBook");
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);
        setVisible(true);
    }
    JTextField fTitle = new JTextField(30);
    JTextField fCategory = new JTextField(30);
    JTextField fPrice = new JTextField(30);
    JLabel title = new JLabel("Title:");
    JLabel category = new JLabel("Category:");
    JLabel price = new JLabel("Price:");

    JPanel createCenter(){

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        category.setFont(new Font(category.getFont().getName(), Font.PLAIN, 20));
        price.setFont(new Font(price.getFont().getName(), Font.PLAIN, 20));
        center.add(title);
        center.add(fTitle);
        center.add(category);
        center.add(fCategory);
        center.add(price);
        center.add(fPrice);
        return center;
    }

    JPanel createSouth(){
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton addBook = new JButton("Thêm Book");
        addBook.setFont(new Font(addBook.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(addBook);
        JButton returnButton = new JButton("Return");
        buttonPanel.add(returnButton);
        returnButton.setActionCommand("Return");
        returnButton.addActionListener(csListener);
        returnButton.setFont(new Font(returnButton.getFont().getName(), Font.BOLD, 20));
        JButton addAu = new JButton("Thêm Author");
        addAu.setFont(new Font(addAu.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(addAu);
        addAu.setActionCommand("addAu");
        addAu.addActionListener(e -> {
            new AddAuthorToBookScreen(authors, cart, store);
        });
        addBook.addActionListener (e -> {
            if (fTitle.getText().isEmpty() || fCategory.getText().isEmpty()|| fPrice.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không được bỏ trống Title/Category/Price", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else if (!fPrice.getText().isEmpty() && !fPrice.getText().matches("\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(this, "Lỗi: Price phải nhập số thực !", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else if(authors.isEmpty()) JOptionPane.showMessageDialog(this, "Lỗi: Chưa có author !", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            else {
                String title1 = fTitle.getText();
                String category1 = fCategory.getText();
                float cost = Float.parseFloat(fPrice.getText());
                Quick.CSARuns(() -> {
                    Book tmp = new Book(title1, category1, cost);
                    for(String name : authors){
                        tmp.addAuthor(name);
                    }
                    store.addMedia(tmp);
                    fTitle.setText("");
                    fCategory.setText("");
                    fPrice.setText("");
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    authors.clear();
                });

            }
        });
        return buttonPanel;
    }
}