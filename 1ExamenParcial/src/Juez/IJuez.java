package Juez;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IJuez extends Remote{
    
    
    ArrayList<Cuenta>ListaCuentas(String ci, String nombres, String apellidos)throws RemoteException;
    boolean RetenerMonto(Cuenta cuenta , int monto , String glosa) throws RemoteException;
    
}
