package hust.dsai.soict.aims.media;

public abstract class Disc extends Media{
    protected int length;
    protected String director;

    public String getDirector(){
        return director;
    }

    public int getLength(){
        return length;
    }

    public Disc(String title, String category, float price, String director){
        super(title,category,price);
        this.director = director;
    }

    public abstract String toString();
}
