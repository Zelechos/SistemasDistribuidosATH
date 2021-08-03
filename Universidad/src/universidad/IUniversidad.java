/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package universidad;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUniversidad extends Remote {

    // Metodos que tenemos que Instanciar en el Servidor
    Diploma EmitirDiploma(String CI, String Nombre,  String PrimerApellido , String SegundoApellido,String FechaNacimiento , String Carrera ) throws RemoteException;
    
}
