package hust.dsai.soict.aims.screen;

import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CartScreen extends BaseFrame {
    public CartScreen(Cart cart, Store store){
        super(store, cart);
        this.setLayout(new BorderLayout());

        JFXPanel fxPanel = new JFXPanel();
        Platform.setImplicitExit(false);

        this.add(fxPanel, BorderLayout.CENTER);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(new Runnable(){
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart, CartScreen.this, store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

        });
    }
}
