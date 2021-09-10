package SistemaDeEmision;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IConexion extends Remote{
    
    //Metodos Abstractos
    ArrayList <Cuenta> ListaCuentas(String CI, String Nombres , String Apellidos) throws RemoteException;
    boolean RetenerMonto(Cuenta cuenta, double Monto) throws RemoteException;    
    
    //Metodos de Testeo
    ArrayList <String> testingServicios() throws RemoteException;
    
}
