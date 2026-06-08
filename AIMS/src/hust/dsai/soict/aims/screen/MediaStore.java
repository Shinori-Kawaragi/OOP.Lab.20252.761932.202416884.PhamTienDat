package hust.dsai.soict.aims.screen;

import hust.dsai.soict.aims.exception.Quick;
import hust.dsai.soict.aims.media.Media;
import hust.dsai.soict.aims.media.Playable;
import hust.dsai.soict.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public MediaStore(Media media, Cart cart){
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getPrice()+"$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addToCart = new JButton("Add to cart");
        container.add(addToCart);
        addToCart.addActionListener(cSListener);
        addToCart.setActionCommand("Add to cart");
        if(media instanceof Playable){
            JButton play = new JButton("Play");
            container.add(play);
            play.addActionListener(cSListener);
            play.setActionCommand("Play");
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private final ActionListener cSListener = e -> {
        String lenh = e.getActionCommand();
        switch (lenh){
            case "Add to cart":
                Quick.CSARuns(() -> {
                    cart.addMedia(media);
                    JOptionPane.showMessageDialog(this,"Đã thêm sản phẩm vào giỏ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                });
                break;
            case "Play":
                Playable play = (Playable) media;
                Quick.CSARuns(() -> {
                    JOptionPane.showMessageDialog(this, play.play(), "Xem trước", JOptionPane.INFORMATION_MESSAGE);
                });
                break;
        }
    };

}