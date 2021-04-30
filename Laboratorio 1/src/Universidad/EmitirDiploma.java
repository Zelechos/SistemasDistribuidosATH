package Universidad;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmitirDiploma extends Remote{
    
    //Metodo Para Emitir el Diploma 
    //Retornara un Objeto de la Clase Diplomado
    Diplomado EmitirDiploma(
            String CI,
            String Nombre,
            String Apellido_Paterno,
            String Apellido_Materno,
            String Carrera,
            String Fecha_Nacimiento)
            throws RemoteException;
    
}
