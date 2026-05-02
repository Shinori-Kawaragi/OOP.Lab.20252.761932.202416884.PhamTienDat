package hust.soict.globalict.garbage;

public class GarbageCreator {
    public static void main (String[] args){
        long start = System.currentTimeMillis();
        String s=" ";
        for(int i=0;i<100000;i++){
            s+="trash";
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}