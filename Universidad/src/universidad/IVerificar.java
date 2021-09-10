package universidad;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVerificar extends Remote{
 
    // Metodos que tenemos que Instanciar en el Servidor
    Respuesta Verificar(String CI, String Nombre , String Apellidos) throws RemoteException;
}
