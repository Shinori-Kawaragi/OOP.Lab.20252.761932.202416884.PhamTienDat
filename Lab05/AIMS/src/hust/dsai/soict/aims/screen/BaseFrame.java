package hust.dsai.soict.aims.screen;

import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;

public abstract class BaseFrame extends JFrame {
    protected Store store;
    protected Cart cart;

    public BaseFrame(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
    }
}