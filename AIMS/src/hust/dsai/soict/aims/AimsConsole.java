package hust.dsai.soict.aims;

import hust.dsai.soict.aims.exception.Quick;
import hust.dsai.soict.aims.media.*;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;

import java.util.Scanner;

public class AimsConsole {
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

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int mode;
        while(true){
            showMenu();
            mode = scan.nextInt();
            if(mode==1){
                int mode1;
                while(true){
                    storeMenu();
                    mode1 = scan.nextInt();
                    if(mode1==4){
                        gio.toString();
                    }
                    else if(mode1!=0){
                        System.out.print("Nhap ten media: ");
                        String ten = scan.next();
                        Media tmp = null;
                        for(Media i : AIM.itemInStore){
                            if(ten.compareToIgnoreCase(i.getTitle())==0){
                                tmp = i;
                                break;
                            }
                        }
                        if(tmp==null){
                            System.out.println("khong co san pham nay");
                        }
                        else{
                            Media tmp0 = tmp;
                            if(mode1 == 1){
                                tmp.toString();
                                int mode2;
                                while(true){
                                    mediaDetailsMenu();
                                    mode2 = scan.nextInt();
                                    if(mode2 == 1){
                                        Quick.CSARuns(() -> {gio.addMedia(tmp0);});
                                    }
                                    else if(mode2 == 2){
                                        if(tmp instanceof Playable){
                                            Playable tmp1 = (Playable)tmp;
                                            Quick.CSARuns(() -> {
                                                tmp1.play();
                                            });
                                        }
                                        else{
                                            System.out.println("Khong the dung thu san pham nay");
                                        }
                                    }
                                    else break;
                                }
                            }
                            else if(mode1 == 2){
                                Quick.CSARuns(() ->{
                                    gio.addMedia(tmp0);
                                    gio.print();
                                });
                            }
                            else{
                                if(tmp instanceof Playable){
                                    Playable tmp1 = (Playable)tmp;
                                    Quick.CSARuns(() -> {
                                        tmp1.play();
                                    });
                                }
                                else{
                                    System.out.println("Khong the dung thu san pham nay");
                                }
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
                    int mode3 = scan.nextInt();
                    if(mode3 == 1){
                        int mode4 = scan.nextInt();
                        System.out.println("1.To add DVD");
                        System.out.println("2.To add CD");
                        System.out.println("3.To add Book");
                        if(mode4 == 1){
                            String title = scan.next();
                            String category = scan.next();
                            String director = scan.next();
                            int length = scan.nextInt();
                            float price = scan.nextFloat();
                            Quick.CSARuns(() -> {
                                DVD tmp = new DVD(title,category,director,length,price);
                                AIM.addMedia(tmp);
                            });
                        }
                        if(mode4 == 2){
                            String title = scan.next();
                            String category = scan.next();
                            String director = scan.next();
                            String artist = scan.next();
                            float price = scan.nextFloat();
                            Quick.CSARuns(() -> {
                                CD tmp = new CD(title,category,director,price,artist);
                                AIM.addMedia(tmp);
                            });
                        }
                        if(mode4 == 3){
                            String title = scan.next();
                            String category = scan.next();
                            String author = scan.next();
                            float price = scan.nextFloat();
                            Quick.CSARuns(() -> {
                                Book tmp = new Book(title,category,price);
                                tmp.addAuthor(author);
                                AIM.addMedia(tmp);
                            });
                        }
                    }
                    else if(mode3 == 2){
                        AIM.print();
                        System.out.print("Chon id san pham can xoa: ");
                        int id = scan.nextInt();
                    }
                    else break;
                }
            }
            else if(mode == 3){
                while(true){
                    cartMenu();
                    int mode6 = scan.nextInt();
                    if(mode6==1){
                        System.out.println("1.Filter by Id");
                        System.out.println("2.Filter by Title");
                        int mode7 = scan.nextInt();
                        if(mode7 == 1){
                            gio.searchTitle(scan.next());
                        }
                        else{
                            gio.searchId(scan.nextInt());
                        }
                    }
                    else if(mode6 == 2){
                        System.out.println("1.Sort by Cost/Title");
                        System.out.println("2.Filter by Title/Cost");
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
                        System.out.print("Nhap id cua san pham can bo:");
                        int id = scan.nextInt();
                        Quick.CSARuns(() -> {
                            gio.removeMedia(id);
                        });
                    }
                    else if(mode6 == 4){
                        gio.print();
                        System.out.print("Nhap id cua san pham:");
                        Media tmp = gio.searchID(scan.nextInt());
                        if(tmp!=null){
                            if (tmp instanceof Playable){
                                Playable tmp1 = (Playable) tmp;
                                Quick.CSARuns(() -> {
                                    tmp1.play();
                                });
                            }
                            else System.out.println("Khong the xem truoc san pham nay");
                        }
                        else{
                            System.out.println("San pham khong ton tai");
                        }
                    }
                    else if(mode6 == 5){
                        System.out.println("Dat hang thanh cong");
                        gio.clearCart();
                    }
                }

            }
        }
    }
}
