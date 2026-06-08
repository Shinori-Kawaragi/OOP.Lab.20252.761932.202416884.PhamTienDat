package hust.dsai.soict.store;

import hust.dsai.soict.aims.media.DVD;
import hust.dsai.soict.aims.media.Media;
import hust.dsai.soict.aims.exception.StoreException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Store {
    public ArrayList<Media> itemInStore = new ArrayList<>();

    public void addMedia(Media a) throws StoreException {
        Media tmp = null;
        for(Media i : itemInStore){
            if(i.equals(a)){
                tmp = i;
                break;
            }
        }
        if(tmp == null){
            itemInStore.add(a);
        }
        else{
            throw new StoreException("Đã tồn tại sản phẩm");
        }
    }
     public void removeMedia(int ID) throws StoreException{
        Media tmp = null;
        for(Media i : itemInStore){
            if(i.getId()==ID){
                tmp=i;
                break;
            }
        }
        if(tmp == null) throw new StoreException("Không có sản phẩm này");
        else{
            itemInStore.remove(tmp);
            System.out.println("Đã xoá sản phẩm");
        }
     }
     public void print(){
        for(Media i : itemInStore){
            System.out.println(i.toString());
        }
     }

    public ArrayList<Media> getItemsInStore() {
        return itemInStore;
    }
}
