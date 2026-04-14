package MainWork;

public class Cart {
    private static final int MAX_ORDER = 20;
    private int qtyOrdered=0;
    private DVD ordered[] = new DVD[MAX_ORDER];

    public boolean checkDVD(String title){
        for(int i=0;i<qtyOrdered;i++){
            if(ordered[i].getTitle().equals(title)) return true;
        }
        return false;
    }
    public void addDVD(DVD disc){
        if(checkDVD(disc.getTitle())){
            System.out.println("DVD da co");
        }
        else if(qtyOrdered==20){
            System.out.println("Da dat gioi han 20 DVD");
        }
        else{
            ordered[qtyOrdered++]=disc;
            System.out.println("Da them DVD");
            if(qtyOrdered==20){
                System.out.println("Chu y: gio hang da day 20 DVD");
            }
        }
    }
    public void removeDVD(DVD disc){
        int j=-1;
        for(int i=0;i<qtyOrdered;i++){
            if(ordered[i]==disc){
                j=i;
                break;
            }
        }
        if(j==-1){
            System.out.println("Trong gio khong co dia nay");
        }
        else{
            for(int i=j;i<qtyOrdered-1;i++){
                ordered[i]=ordered[i+1];
            }
            ordered[--qtyOrdered]=null;
            System.out.println("Da loai bo dia");
        }
    }
    public void checkPrice(){
        float tong=0;
        for(int i=0;i<qtyOrdered;i++){
            tong+=ordered[i].getPrice();
        }
        System.out.println("Tong so tien la:"+tong);
    }
}

