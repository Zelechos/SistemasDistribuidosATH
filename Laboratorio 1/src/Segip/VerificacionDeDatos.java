package Segip;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VerificacionDeDatos extends Remote{
    
    //Metodo abstracto
    Respuesta VerificarDatos(String CI,
            String Nombre ,
            String Apellido)
            throws RemoteException;
    
}
