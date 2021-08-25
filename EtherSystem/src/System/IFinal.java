package System;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFinal extends Remote{
    
    //Metodos Abstractos
    String Mensaje() throws RemoteException;
    
}
