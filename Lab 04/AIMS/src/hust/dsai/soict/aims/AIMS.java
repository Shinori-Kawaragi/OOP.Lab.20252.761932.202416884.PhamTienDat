package hust.dsai.soict.aims;

import hust.dsai.soict.aims.media.*;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AIMS {
    public static Store AIM = new Store();
    public static Cart gio = new Cart();
    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("________________");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("________________");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu(){
        System.out.println("Options: ");
        System.out.println("________________");
        System.out.println("1.See a media's details");
        System.out.println("2.Add a media to cart");
        System.out.println("3.Play a media");
        System.out.println("4.See current cart");
        System.out.println("0.Back");
        System.out.println("________________");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(){
        System.out.println("Options: ");
        System.out.println("________________");
        System.out.println("1.Add to cart");
        System.out.println("2.Play");
        System.out.println("0.Back");
        System.out.println("________________");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu(){
        System.out.println("Options: ");
        System.out.println("________________");
        System.out.println("1.Filter medias in cart");
        System.out.println("2.Sort medias in cart");
        System.out.println("3.Remove media from cart");
        System.out.println("4.Play a media");
        System.out.println("5.Place order");
        System.out.println("0.Back");
        System.out.println("________________");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void play(Media a){
        if(a instanceof Playable){
            Playable tmp = (Playable) a;
            tmp.play();
            return;
        }
        System.out.println("Can not playtest this product");
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int mode;
        while(true){
            showMenu();
            System.out.print("Input:");
            mode = scan.nextInt();
            if(mode==1){
                int mode1;
                while(true){
                    AIM.print();
                    storeMenu();
                    System.out.print("Input:");
                    mode1 = scan.nextInt();
                    if(mode1==4){
                        gio.print();
                    }
                    else if(mode1!=0){
                        System.out.print("Title: ");
                        String ten = scan.next();
                        Media tmp = null;
                        for(Media i : AIM.itemInStore){
                            if(ten.compareToIgnoreCase(i.getTitle())==0){
                                tmp = i;
                                break;
                            }
                        }
                        if(tmp==null){
                            System.out.println("Product does not exist");
                        }
                        else{
                            if(mode1 == 1){
                                System.out.println(tmp.toString());
                                int mode2;
                                while(true){
                                    mediaDetailsMenu();
                                    System.out.print("Input:");
                                    mode2 = scan.nextInt();
                                    if(mode2 == 1){
                                        gio.addMedia(tmp);
                                    }
                                    else if(mode2 == 2){
                                        AIMS.play(tmp);
                                    }
                                    else break;
                                }
                            }
                            else if(mode1 == 2){
                                gio.addMedia(tmp);
                                gio.print();
                            }
                            else{
                                AIMS.play(tmp);
                            }
                        }
                    }
                    else break;
                }
            }
            else if(mode == 2){
                while(true){
                    System.out.println("1.Add a product");
                    System.out.println("2.Remove a product");
                    System.out.println("0.Exit");
                    System.out.print("Input:");
                    int mode3 = scan.nextInt();
                    if(mode3 == 1){
                        System.out.println("1.To add DVD");
                        System.out.println("2.To add CD");
                        System.out.println("3.To add Book");
                        System.out.print("Input:");
                        int mode4 = scan.nextInt();
                        if(mode4 == 1){
                            System.out.print("Title:");
                            String title = scan.next();
                            System.out.print("Category:");
                            String category = scan.next();
                            System.out.print("Director:");
                            String director = scan.next();
                            System.out.print("Length:");
                            int length = scan.nextInt();
                            System.out.print("Price:");
                            float price = scan.nextFloat();
                            DVD tmp = new DVD(title,category,director,length,price);
                            AIM.addMedia(tmp);
                        }
                        if(mode4 == 2){
                            System.out.print("Title:");
                            String title = scan.next();
                            System.out.print("Category:");
                            String category = scan.next();
                            System.out.print("Director:");
                            String director = scan.next();
                            System.out.print("Artist:");
                            String artist = scan.next();
                            System.out.print("Price:");
                            float price = scan.nextFloat();
                            CD tmp = new CD(title,category,director,price,artist);
                            System.out.print("How many Track:");
                            int soT = scan.nextInt();
                            for(int i = 0 ; i < soT; i++){
                                System.out.print("Title:");
                                String ten = scan.next();
                                System.out.print("Length:");
                                int dai = scan.nextInt();
                                Track tmp1 = new Track(ten,dai);
                                tmp.addTrack(tmp1);
                            }
                            AIM.addMedia(tmp);
                        }
                        if(mode4 == 3){
                            System.out.print("Title:");
                            String title = scan.next();
                            System.out.print("Category:");
                            String category = scan.next();
                            System.out.print("Price:");
                            float price = scan.nextFloat();
                            Book tmp = new Book(title,category,price);
                            System.out.print("How many Authors:");
                            int soA = scan.nextInt();
                            for(int i = 0;i < soA;i++) {
                                System.out.print("Name:");
                                String author = scan.next();
                                tmp.addAuthor(author);
                            }
                            AIM.addMedia(tmp);
                        }
                    }
                    else if(mode3 == 2){
                        AIM.print();
                        System.out.print("id to remove: ");
                        int id = scan.nextInt();
                        AIM.removeMedia(id);
                    }
                    else break;
                }
            }
            else if(mode == 3){
                while(true){
                    cartMenu();
                    System.out.print("Input:");
                    int mode6 = scan.nextInt();
                    if(mode6==1){
                        System.out.println("1.Filter by Id");
                        System.out.println("2.Filter by Title");
                        System.out.print("Input:");
                        int mode7 = scan.nextInt();
                        if(mode7 == 1){
                            System.out.print("Id to Search:");
                            gio.searchId(scan.nextInt());
                        }
                        else{
                            System.out.print("Title to Search:");
                            gio.searchTitle(scan.next());
                        }
                    }
                    else if(mode6 == 2){
                        System.out.println("1.Sort by Cost/Title");
                        System.out.println("2.Sort by Title/Cost");
                        System.out.print("Input:");
                        int mode8 = scan.nextInt();
                        if(mode8 == 1){
                            gio.sortCostTitle();
                        }
                        else{
                            gio.sortTitleCost();
                        }
                    }
                    else if(mode6 == 3){
                        gio.print();
                        System.out.print("id to remove:");
                        int id = scan.nextInt();
                        gio.removeMedia(id);
                    }
                    else if(mode6 == 4){
                        gio.print();
                        System.out.print("id:");
                        Media tmp = gio.searchID(scan.nextInt());
                        if(tmp!=null){
                            AIMS.play(tmp);
                        }
                        else{
                            System.out.println("Product does not exist");
                        }
                    }
                    else if(mode6 == 5){
                        System.out.println("Ordered Successfully");
                        gio.clearCart();
                    }
                    else break;
                }
            }
            else break;
        }
    }
}
