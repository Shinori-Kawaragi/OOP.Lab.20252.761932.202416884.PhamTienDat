package hust.dsai.soict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle(){
        return title;
    }

    public int getLength(){
        return length;
    }

    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    public void play(){
        System.out.println("Playing Track: " + title);
        System.out.println("Length: " + length);
    }

    @Override
    public boolean equals(Object o){
        if(o == null || !(o instanceof Track)) return false;
        Track tmp = (Track)o;
        if(tmp.getTitle().equals(this.getTitle()) && tmp.getLength() == this.getLength()) return true;
        return false;
    }
}
