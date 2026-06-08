package hust.dsai.soict.aims.exception;

public class Quick {
    public static void CSARuns(CSA a){
        try{
            a.execute();
        }catch (Exception e){
            AimsExceptionDealer.handle(e);
        }
    }
}
