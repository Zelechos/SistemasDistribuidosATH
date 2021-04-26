/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Operaciones;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperaciones  extends Remote {
    // Metodos que tenemos que Instanciar en el Servidor
    int sumar(int a,int b) throws RemoteException;
    int restar(int a,int b)throws RemoteException;
    
}
