package System;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMensajeRMI extends Remote{
    
//Metodos Abstractos
   String MensajeRMI() throws RemoteException;
}
