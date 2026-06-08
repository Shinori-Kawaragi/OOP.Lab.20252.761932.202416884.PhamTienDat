package hust.dsai.soict.cart;

import hust.dsai.soict.aims.exception.CartException;
import hust.dsai.soict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class Cart {
    private static final int MAX_ORDER = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

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

    public void addMedia(Media a) throws CartException {
        if(itemsOrdered.size() < MAX_ORDER) {
            Media tmp = null;
            for (Media i : itemsOrdered) {
                if (i.equals(a)) {
                    tmp = i;
                    break;
                }
            }
            if (tmp != null) throw new CartException("Sản phẩm đã tồn tại trong giỏ");
            else {
                itemsOrdered.add(a);
                System.out.println("da them san pham");
            }
        }
        else{
            throw new CartException("Giỏ đã đầy");
        }
    }

    public void removeMedia(int id) throws CartException{
        Media tmp = null;
        for(Media i : itemsOrdered){
            if(i.getId() == id){
                tmp = i;
                break;
            }
        }
        if(tmp == null){
            throw new CartException("Sản phẩm không tồn tại");
        }
        else{
            itemsOrdered.remove(tmp);
            System.out.println("Đã xoá sản phẩm");
        }
    }

    public void checkPrice(){
        float tong = 0;
        for(Media a: itemsOrdered){
            tong += a.getPrice();
        }
        System.out.println("Tong so tien la: "+tong);
    }
    public void print(){
        System.out.println("**********CART**********");
        System.out.println("Ordered Items:");
        for(Media i : itemsOrdered){
            System.out.println(i.toString());
        }
        System.out.print("Total cost: ");
        checkPrice();
    }
    public void searchId(int ID){
        int z=0;
        System.out.println("**********CART**********");
        System.out.println("Ket qua: ");
        for(Media i : itemsOrdered){
            if(i.getId()==ID){
                System.out.println(i.toString());
                z++;
            }
        }
        if(z==0){
            System.out.println("Khong tim thay");
        }
    }
    public void searchTitle(String TITLE){
        int z=0;
        System.out.println("**********CART**********");
        System.out.println("Ket qua: ");
        for(Media i : itemsOrdered){
            if(i.getTitle().equals(TITLE)){
                System.out.println(i.toString());
                z++;
            }
        }
        if(z==0){
            System.out.println("Khong tim thay");
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

    public ObservableList<Media> getItemOrdered(){
        return itemsOrdered;
    }
}
