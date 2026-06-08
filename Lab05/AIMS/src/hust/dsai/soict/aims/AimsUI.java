package hust.dsai.soict.aims;

import hust.dsai.soict.aims.exception.Quick;
import hust.dsai.soict.aims.media.Book;
import hust.dsai.soict.aims.media.CD;
import hust.dsai.soict.aims.media.DVD;
import hust.dsai.soict.aims.media.Track;
import hust.dsai.soict.aims.screen.StoreScreen;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import javax.swing.*;

public class AimsUI {
    public static Store AIM = new Store();
    public static Cart gio = new Cart();

    public static void main(String[] args){
        Quick.CSARuns(() -> {
            DVD dvd1 = new DVD("Star War","Sci-fi","Lucas",120,10.00f);
            AIM.addMedia(dvd1);
            Book book1 = new Book("Harry Potter","Fantasy",10.00f);
            AIM.addMedia(book1);
            CD cd1 = new CD("Relapse","Hip-Hop", "Dr.Dre",10.00f,"Eminem");
            cd1.addTrack(new Track("Beautiful",4));
            AIM.addMedia(cd1);
        });
        SwingUtilities.invokeLater(() -> {
            new StoreScreen(AIM, gio);
        });
    }
}
