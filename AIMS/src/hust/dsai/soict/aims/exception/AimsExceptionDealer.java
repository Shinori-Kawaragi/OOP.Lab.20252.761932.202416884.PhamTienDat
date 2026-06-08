package hust.dsai.soict.aims.exception;

import javax.swing.*;

public class AimsExceptionDealer {
    public static void handle(Exception e){
        if (e instanceof AimsException){
            AimsException e1 = (AimsException) e;
            JOptionPane.showMessageDialog(null, e1.getMessage(),e1.getErrorTitle(),JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Phát sinh lỗi ngoài AIMS","Cảnh báo",JOptionPane.WARNING_MESSAGE);
        }
    }
}