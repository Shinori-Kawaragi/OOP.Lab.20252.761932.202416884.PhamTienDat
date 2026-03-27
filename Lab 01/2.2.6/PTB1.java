package Lab;

import java.util.Scanner;
public class PTB1 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("nhap he so a: ");
        double a = scan.nextDouble();
        System.out.print("nhap he so b: ");
        double b=scan.nextDouble();
        if(a==0 && b==0) System.out.println("Vo so nghiem");
        else if(a==0 && b!=0) System.out.println("Vo nghiem");
        else System.out.println("Nghiem la: " + (-b/a));
    }
}