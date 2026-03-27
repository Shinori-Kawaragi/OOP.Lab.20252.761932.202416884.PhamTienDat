package Lab;

import java.util.Scanner;
public class PTB2 {
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        System.out.print("Nhap he so a:");
        double a = scan.nextDouble();
        System.out.print("Nhap he so b:");
        double b = scan.nextDouble();
        System.out.print("Nhap he so c:");
        double c = scan.nextDouble();
        double delta = b*b-4*a*c;
        if(a==0) System.out.println("a khong duoc bang 0");
        else if(delta < 0) System.out.println("Vo nghiem");
        else if(delta ==0) System.out.println("Nghiem kep: " + (-b/(2*a)));
        else{
            double can=Math.sqrt(delta);
            System.out.println("Nghiem 1: " + (-b+can)/(2*a) + " va Nghiem 2: " +(-b-can)/(2*a));
        }

    }
}