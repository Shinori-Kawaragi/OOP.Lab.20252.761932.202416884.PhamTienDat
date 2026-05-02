package hust.soict.dsai.store;

import hust.soict.dsai.disc.DVD;

public class Store {
    private static int disc=0;
    public static DVD[] itemInStore = new DVD[2000];

    public void addDisc(DVD dvd){
        int j=-1;
        for(int i=0;i<disc;i++){
            if(itemInStore[i]==dvd){
                j=i;
                break;
            }
        }
        if(j==-1){
            itemInStore[disc++]=dvd;
            System.out.println("da them dia");
        }
        else System.out.println("Da co dia nay");
    }
     public void removeDisc(int ID){
        int j=-1;
        for(int i=0;i<disc;i++){
            if(itemInStore[i].getId()==ID){
                j=i;
                break;
            }
        }
        if(j==-1) System.out.println("Khong co dia nay");
        else{
            for(int i=j;i<disc-1;i++){
                itemInStore[i]=itemInStore[i+1];
            }
            itemInStore[disc-1] = null;
            disc--;
            System.out.println("da xoa dia");
        }
     }

}
