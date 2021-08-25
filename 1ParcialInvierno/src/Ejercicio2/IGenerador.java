/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGenerador extends Remote {

    // Metodos que tenemos que Instanciar en el Servidor
    boolean introducirvalor(String cadena) throws RemoteException;
    
    //Devuelve la Cadena Duplicada
    String duplicar () throws RemoteException;

    //Devuelve la cadena y aumenta N espacios entre cada letra
    String aumentarespacios(int Number) throws RemoteException;

    //Devuelve la cadena N mayuscula
    String mayuscula(String cadena) throws RemoteException;

}
