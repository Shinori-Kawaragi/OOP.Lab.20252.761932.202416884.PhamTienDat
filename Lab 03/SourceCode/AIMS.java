package MainWork;

public class AIMS {
    public static void main(String[] args){
        Cart anOrder = new Cart();
        DVD dvd1 = new DVD("The Lion King","Animation","Roger Allers",87,19.95f);
        anOrder.addDVD(dvd1);
        DVD dvd2 = new DVD("Star Wars","SciFi","George Lucas",87,24.95f);
        anOrder.addDVD(dvd2);
        DVD dvd3 = new DVD("Aladin","Animation",18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        anOrder.addDVD(dvd3);
        DVD dvd4 = new DVD("Star Wars","SciFi","George Lucas",87,24.95f);
        anOrder.addDVD(dvd4);
        anOrder.removeDVD(dvd3);
        anOrder.checkPrice();
    }
}
