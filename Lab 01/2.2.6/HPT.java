package HePhuongTrinh;
import java.util.Scanner;

public class HPT {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double a11,a12,a21,a22,b1,b2;
        System.out.print("Nhap he so a11: ");
        a11=scan.nextDouble();
        System.out.print("Nhap he so a12: ");
        a12=scan.nextDouble();
        System.out.print("Nhap he so b1: ");
        b1=scan.nextDouble();
        System.out.print("Nhap he so a21: ");
        a21=scan.nextDouble();
        System.out.print("Nhap he so a22: ");
        a22=scan.nextDouble();
        System.out.print("Nhap he so b2: ");
        b2=scan.nextDouble();
        double detChinh=a11*a22-a12*a21;
        double detPhu1=a22*b1-b2*a12;
        double detPhu2=a11*b2-a21*b1;
        if(detChinh!=0){
            System.out.println("x1 = " + detPhu1/detChinh+ " ,x2 = " + detPhu2/detChinh);
        }
        else{
            if(detPhu1==0 && detPhu2==0) System.out.println("Vo so nghiem");
            else System.out.println("Vo nghiem");
        }
    }
}