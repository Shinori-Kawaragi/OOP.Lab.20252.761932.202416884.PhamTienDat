package hust.dsai.soict.aims.screen;

import hust.dsai.soict.aims.exception.Quick;
import hust.dsai.soict.aims.media.DVD;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDVDToStoreScreen extends AddItemToStoreScreen{
    public AddDVDToStoreScreen(Store store, Cart cart){
        super(store, cart);
        Container cp = getContentPane();
        this.setTitle("AddDVD");
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);
        setVisible(true);
    }
    JTextField fTitle = new JTextField(30);
    JTextField fCategory = new JTextField(30);
    JTextField fDirector = new JTextField(30);
    JTextField fLength = new JTextField(30);
    JTextField fPrice = new JTextField(30);
    JLabel title = new JLabel("Title:");
    JLabel category = new JLabel("Category:");
    JLabel director = new JLabel("Director:");
    JLabel length = new JLabel("Length:");
    JLabel price = new JLabel("Price:");
    JPanel createCenter(){

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        category.setFont(new Font(category.getFont().getName(), Font.PLAIN, 20));
        director.setFont(new Font(director.getFont().getName(), Font.PLAIN, 20));
        length.setFont(new Font(length.getFont().getName(), Font.PLAIN, 20));
        price.setFont(new Font(price.getFont().getName(), Font.PLAIN, 20));

        center.add(title);
        center.add(fTitle);
        center.add(category);
        center.add(fCategory);
        center.add(director);
        center.add(fDirector);
        center.add(length);
        center.add(fLength);
        center.add(price);
        center.add(fPrice);
        return center;
    }

    JPanel createSouth(){
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton addDVD = new JButton("Thêm DVD");
        addDVD.setFont(new Font(addDVD.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(addDVD);
        JButton returnButton = new JButton("Return");
        buttonPanel.add(returnButton);
        returnButton.setActionCommand("Return");
        returnButton.addActionListener(csListener);
        returnButton.setFont(new Font(returnButton.getFont().getName(), Font.BOLD, 20));

        addDVD.addActionListener ( e -> {
            if (fTitle.getText().isEmpty() || fCategory.getText().isEmpty() || fDirector.getText().isEmpty() || fLength.getText().isEmpty() || fPrice.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không được bỏ trống Title/Category/Director/Length/Price", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else if (!fLength.getText().isEmpty() && !fLength.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Lỗi: Length phải nhập số nguyên ", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else if (!fPrice.getText().isEmpty() && !fPrice.getText().matches("\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(this, "Lỗi: Price phải nhập số thực !", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String title1 = fTitle.getText();
                String category1 = fCategory.getText();
                String director1 = fDirector.getText();
                float cost = Float.parseFloat(fPrice.getText());
                int length1 = Integer.parseInt(fLength.getText());
                Quick.CSARuns(() -> {
                    DVD tmp = new DVD(title1, category1, director1, length1, cost);
                    store.addMedia(tmp);
                    JOptionPane.showMessageDialog(this, "Đã thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    fTitle.setText("");
                    fCategory.setText("");
                    fDirector.setText("");
                    fLength.setText("");
                    fPrice.setText("");
                });
            }
        });
        return buttonPanel;
    }
}
