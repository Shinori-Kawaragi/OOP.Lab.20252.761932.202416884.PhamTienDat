package hust.soict.globalict.garbage;

public class NoGarbage {
	public static void main(String[] args){
        String s="";
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<100000;i++){
            sb.append("trash");
        }
        s=sb.toString();
        System.out.println(System.currentTimeMillis() - start);
    }
}


