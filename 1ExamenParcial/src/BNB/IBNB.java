package BNB;

import Juez.Cuenta;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IBNB  extends Remote{
    
    ArrayList<Cuenta>ObtenerSaldo(String ci, String nombres, String apellidos)throws RemoteException;

}
