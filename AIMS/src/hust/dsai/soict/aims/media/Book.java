package hust.dsai.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private static int nbBook = 0;
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float price){
        super(title,category,price);
        nbBook++;
    }

    public void addAuthor(String ten){
        if(!authors.contains(ten)){
            authors.add(ten);
            System.out.println("Author added");
            return;
        }
        System.out.println("Author already existed");
    }

    public void removeAuthor(String ten){
        if(authors.contains(ten)){
            authors.remove(ten);
            System.out.println("Author removed");
            return;
        }
        System.out.println("Author can not be found");
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
        bob.append(this.price);
        bob.append(" $ - ");
        bob.append("tac gia: ");
        for(String a : authors){
            bob.append(a);
            bob.append(" ");
        }
        return bob.toString();
    }

    public static int getNbBook(){
        return nbBook;
    }
}
