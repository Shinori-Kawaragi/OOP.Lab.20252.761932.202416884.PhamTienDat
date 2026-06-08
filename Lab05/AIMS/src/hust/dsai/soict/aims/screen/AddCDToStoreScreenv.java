package hust.dsai.soict.aims.screen;

import hust.dsai.soict.aims.exception.Quick;
import hust.dsai.soict.aims.media.CD;
import hust.dsai.soict.aims.media.Track;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCDToStoreScreen extends AddItemToStoreScreen{
    private ArrayList<Track> ds = new ArrayList<>();
    public AddCDToStoreScreen(Store store, Cart cart){
        super(store, cart);
        Container cp = getContentPane();
        setTitle("AddCD");
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);
        setVisible(true);
    }
    JTextField fTitle = new JTextField(30);
    JTextField fCategory = new JTextField(30);
    JTextField fDirector = new JTextField(30);
    JTextField fPrice = new JTextField(30);
    JTextField fArtist = new JTextField(30);
    JLabel title = new JLabel("Title:");
    JLabel category = new JLabel("Category:");
    JLabel director = new JLabel("Director:");
    JLabel price = new JLabel("Price:");
    JLabel artist = new JLabel("Artist:");

    JPanel createCenter(){

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        category.setFont(new Font(category.getFont().getName(), Font.PLAIN, 20));
        director.setFont(new Font(director.getFont().getName(), Font.PLAIN, 20));
        price.setFont(new Font(price.getFont().getName(), Font.PLAIN, 20));
        artist.setFont(new Font(artist.getFont().getName(), Font.PLAIN, 20));
        center.add(title);
        center.add(fTitle);
        center.add(category);
        center.add(fCategory);
        center.add(director);
        center.add(fDirector);
        center.add(price);
        center.add(fPrice);
        center.add(artist);
        center.add(fArtist);
        return center;
    }

    JPanel createSouth(){
        JButton addDVD = new JButton("Thêm CD");
        addDVD.setFont(new Font(addDVD.getFont().getName(), Font.BOLD, 20));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.add(addDVD);
        JButton returnButton = new JButton("Return");
        buttonPanel.add(returnButton);
        returnButton.setActionCommand("Return");
        returnButton.addActionListener(csListener);
        returnButton.setFont(new Font(returnButton.getFont().getName(), Font.BOLD, 20));
        JButton addTrack = new JButton("AddTrack");
        addTrack.setFont(new Font(addTrack.getFont().getName(), Font.BOLD, 20));
        buttonPanel.add(addTrack);
        addTrack.addActionListener(e -> {
            new AddTrackToCDScreen(ds,store,cart);
        });

        addDVD.addActionListener ( e -> {
            if (fTitle.getText().isEmpty() || fCategory.getText().isEmpty() || fDirector.getText().isEmpty() || fArtist.getText().isEmpty() || fPrice.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không được bỏ trống Title/Category/Director/Artist/Price", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else if (!fPrice.getText().isEmpty() && !fPrice.getText().matches("\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(this, "Lỗi: Price phải nhập số thực !", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
            else if(ds.isEmpty()) JOptionPane.showMessageDialog(this, "Lỗi: Chua có Track !", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            else {
                String title1 = fTitle.getText();
                String category1 = fCategory.getText();
                String director1 = fDirector.getText();
                float cost = Float.parseFloat(fPrice.getText());
                String artist1 = fArtist.getText();
                Quick.CSARuns(() -> {
                    CD tmp = new CD(title1, category1, director1, cost, artist1);
                    for(Track i : ds){
                        tmp.addTrack(i);
                    }
                    store.addMedia(tmp);
                    JOptionPane.showMessageDialog(this, "Đã thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    fTitle.setText("");
                    fCategory.setText("");
                    fDirector.setText("");
                    fArtist.setText("");
                    fPrice.setText("");
                    ds.clear();
                });
            }
        });
        return buttonPanel;
    }
}
