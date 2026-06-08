package hust.dsai.soict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media a, Media b){
        int tmp = a.getTitle().compareToIgnoreCase(b.getTitle());
        if(tmp != 0) return tmp;
        return Float.compare(a.getPrice(),b.getPrice());
    }
}