package hust.dsai.soict.aims.media;

public class DVD extends Disc implements Playable{
    private static int nbDVD = 0;
    public DVD(String title, String category, String director, int length,float price){
        super(title, category, price, director);
        this.length = length;
        nbDVD++;
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
        bob.append(this.length);
        bob.append(" - ");
        bob.append(this.price);
        bob.append(" $");
        return bob.toString();
    }
    public static int getNbDVD(){
        return nbDVD;
    }

    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}