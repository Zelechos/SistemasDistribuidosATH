package SistemaDeEmision;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IConexionBNB {
    
    //Metodos Abstractos
    ArrayList <Cuenta> ObtenerSaldo(String CI, String Nombres , String Apellidos) throws RemoteException;
    
    
    //Metodo de Testeo 
    String testing()throws RemoteException;
}
