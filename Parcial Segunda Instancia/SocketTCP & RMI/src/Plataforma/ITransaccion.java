/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Plataforma;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITransaccion extends Remote{
    
    //Metodos Abstractos
    boolean realizarTransaccion(String nrocuentacliente , String cuentavendedor , int monto , String moneda) throws RemoteException;
}
