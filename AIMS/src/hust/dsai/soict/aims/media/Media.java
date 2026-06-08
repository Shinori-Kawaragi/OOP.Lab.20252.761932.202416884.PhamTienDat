package hust.dsai.soict.aims.media;

import java.util.Comparator;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float price;

    protected static int nbMedia = 0;

    public Media(String title, String category, float price){
        this.title = title;
        this.category = category;
        this.price = price;
        this.id = nbMedia++;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public float getPrice(){
        return price;
    }

    public String getCategory(){
        return category;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o){
        if(o == null || !(o instanceof Media)) return false;
        Media tmp = (Media)o;
        if(tmp.getTitle().equals(this.getTitle())) return true;
        return false;
    }

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();




}