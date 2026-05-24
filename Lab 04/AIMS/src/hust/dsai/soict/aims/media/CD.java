package hust.dsai.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CD extends Disc implements Playable{
    private static int nbCD = 0;
    private String artist;
    private List<Track> ds = new ArrayList<>();

    public CD(String title, String category, String director,float price, String artist){
        super(title,category,price,director);
        this.artist = artist;
        this.length = 0;
        nbCD++;
    }

    public void addTrack(Track a){
        Track tmp = null;
        for(Track i : ds){
            if(i.equals(a)){
                tmp=i;
                break;
            }
        }
        if(tmp == null){
            ds.add(a);
            System.out.println("Track added");
            length += a.getLength();
        }
        else{
            System.out.println("Track already existed");
        }
    }

    public void removeTrack(String ten){
        Track tmp = null;
        for(Track i : ds){
            if(i.getTitle().equals(ten)){
                tmp=i;
                break;
            }
        }
        if(tmp == null){
            System.out.println("Track does not exist");
        }
        else{
            ds.remove(tmp);
            System.out.println("Track removed");
        }
    }

    public void play(){
        System.out.println("Playing CD: " + title);
        System.out.println("By " + artist);
        System.out.println("length: " + length);
        for(Track a : ds){
            a.play();
        }
    }

    @Override
    public String toString(){
        StringBuilder bob = new StringBuilder();
        bob.append(this.id);
        bob.append(" - ");
        bob.append(this.title);
        bob.append(" - ");
        bob.append(this.category);
        bob.append(" - ");
        bob.append(this.director);
        bob.append(" - ");
        bob.append(this.artist);
        bob.append(" - ");
        bob.append(this.length);
        bob.append(" - ");
        bob.append(this.price);
        bob.append(" $");
        return bob.toString();
    }

    public static int getnbCD(){
        return nbCD;
    }

}