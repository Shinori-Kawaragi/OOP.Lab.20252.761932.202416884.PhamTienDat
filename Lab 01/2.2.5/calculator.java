package calculator;

import java.util.Scanner;
public class calculator1 {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            System.out.print("Nhap so dau tien: ");
            String so1 = scan.next();
            System.out.print("Nhap so thu hai: ");
            String so2 = scan.next();
            double s1=Double.parseDouble(so1);
            double s2=Double.parseDouble(so2);
            System.out.println("Tong:" + (s1+s2));
            System.out.println("Hieu:" + (s1-s2));
            System.out.println("Tich:" + (s1*s2));
            if(s2==0){
                System.out.println("Ko the chia");
            }
            else System.out.println("Thuong:" + (s1/s2));
        }
}