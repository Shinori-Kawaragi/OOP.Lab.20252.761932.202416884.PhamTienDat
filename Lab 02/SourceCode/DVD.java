package MainWork;

public class DVD {
    private String title;
    private String category;
    private String director;
    private int length;
    private float price;

    public DVD(String title, String category, String director, int length,float price){
        this.title=title;
        this.category=category;
        this.director=director;
        this.length=length;
        this.price=price;
    }
    public DVD(String title, String category,float price){
        this.title=title;
        this.category=category;
        this.price=price;
    }
    public DVD(String title){
        this.title=title;
    }
    public DVD(String title, String category, String director, float price){
        this.title=title;
        this.category=category;
        this.director=director;
        this.price=price;
    }

    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public float getPrice(){
        return price;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setDirector(String director){
        this.director=director;
    }
    public void setLength(int length){
        this.length=length;
    }
    public void setPrice(float price){
        this.price=price;
    }
}

