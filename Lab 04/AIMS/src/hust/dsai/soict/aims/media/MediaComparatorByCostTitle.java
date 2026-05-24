package hust.dsai.soict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media a, Media b){
        int tmp = a.getTitle().compareToIgnoreCase(b.getTitle());
        if(a.getPrice() > b.getPrice()) return 1;
        else if(a.getPrice() == b.getPrice()){
            return tmp;
        }
        return -1;
    }
}
