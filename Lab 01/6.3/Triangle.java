package Lab;
import java.util.Scanner;
public class Triangle {
    public static void main(String[] args){
        Scanner nhap=new Scanner(System.in);
        System.out.print("Nhap so:");
        int n=nhap.nextInt();
        int z=n*2-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<z/2-i;j++) System.out.print(" ");
            for(int j=0;j<2*i+1;j++) System.out.print("*");
            for(int j=0;j<z/2-i;j++) System.out.print(" ");
            System.out.println("");
        }   
    }
}