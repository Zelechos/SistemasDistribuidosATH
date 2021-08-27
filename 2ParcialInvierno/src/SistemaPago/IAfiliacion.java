/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package SistemaPago;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAfiliacion extends Remote {

    String SolicitarAfiliacion(String ci, String nombres, String apellidos, String fechanacimiento)throws RemoteException;
    
    String Show()throws RemoteException;

}
