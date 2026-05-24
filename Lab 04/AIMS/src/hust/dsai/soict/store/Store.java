package hust.dsai.soict.store;

import hust.dsai.soict.aims.media.DVD;
import hust.dsai.soict.aims.media.Media;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Store {
    public List<Media> itemInStore = new ArrayList<>();

    public void addMedia(Media a){
        Media tmp = null;
        for(Media i : itemInStore){
            if(i.equals(a)){
                tmp = i;
                break;
            }
        }
        if(tmp == null){
            itemInStore.add(a);
            System.out.println("Product Added");
        }
        else{
            System.out.println("Product Existed");
        }
    }
    public void removeMedia(int ID){
        Media tmp = null;
        for(Media i : itemInStore){
            if(i.getId()==ID){
                tmp=i;
                break;
            }
        }
        if(tmp == null) System.out.println("Product Not Exist");
        else{
            itemInStore.remove(tmp);
            System.out.println("Product Removed");
        }
    }
    public void print(){
        System.out.println("**********STORE**********");
        System.out.println("ItemsInStore:");
        for(Media i : itemInStore){
            System.out.println(i.toString());
        }
    }

}