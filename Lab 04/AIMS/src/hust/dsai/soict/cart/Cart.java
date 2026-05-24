package hust.dsai.soict.cart;

import hust.dsai.soict.aims.media.DVD;
import hust.dsai.soict.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Cart {
    private static final int MAX_ORDER = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public Media searchID(int id){
        Media tmp = null;
        for(Media i : itemsOrdered){
            if(i.getId() == id){
                tmp = i;
                break;
            }
        }
        if(tmp == null){
            return null;
        }
        else return tmp;
    }

    public void addMedia(Media a){
        if(itemsOrdered.size()>=20){
            System.out.println("Cart is full");
            return;
        }
        Media tmp = null;
        for(Media i : itemsOrdered){
            if(i.equals(a)){
                tmp = i;
                break;
            }
        }
        if(tmp!=null){
            System.out.println("Product already added");
        }
        else{
            itemsOrdered.add(a);
            System.out.println("Product added");
        }
    }

    public void removeMedia(int id){
        Media tmp = null;
        for(Media i : itemsOrdered){
            if(i.getId() == id){
                tmp = i;
                break;
            }
        }
        if(tmp == null){
            System.out.println("Product can not be found");
        }
        else{
            itemsOrdered.remove(tmp);
            System.out.println("Product removed");
        }
    }

    public void checkPrice(){
        float tong=0;
        for(Media a: itemsOrdered){
            tong += a.getPrice();
        }
        System.out.println("Total Amount : "+tong);
    }
    public void print(){
        System.out.println("**********CART**********");
        System.out.println("Ordered Items:");
        for(Media i : itemsOrdered){
            System.out.println(i.toString());
        }
        checkPrice();
    }
    public void searchId(int ID){
        int z=0;
        System.out.println("**********CART**********");
        System.out.println("Results: ");
        for(Media i : itemsOrdered){
            if(i.getId()==ID){
                System.out.println(i.toString());
                z++;
            }
        }
        if(z==0){
            System.out.println("Can not found");
        }
    }
    public void searchTitle(String TITLE){
        int z=0;
        System.out.println("**********CART**********");
        System.out.println("Results: ");
        for(Media i : itemsOrdered){
            if(i.getTitle().equals(TITLE)){
                System.out.println(i.toString());
                z++;
            }
        }
        if(z==0){
            System.out.println("Can not found");
        }
    }

    public void sortTitleCost(){
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        print();
    }

    public void sortCostTitle(){
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        print();
    }

    public void clearCart(){
        this.itemsOrdered.clear();
    }
}
