package System;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteRMI {

    public static void main(String[] args) {
        IMensajeRMI ServidorRMI;

        try {
            
            ServidorRMI = (IMensajeRMI) Naming.lookup("rmi://localhost/RMI");
            String text = ServidorRMI.MensajeRMI();
            System.out.println(text);
            

        }catch (NotBoundException | MalformedURLException | RemoteException ex) {} 
    }

}
