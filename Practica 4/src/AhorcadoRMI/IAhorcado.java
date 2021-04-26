package AhorcadoRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAhorcado extends Remote{
    
    //Metodos Abstractos
    String Iniciar() throws RemoteException;
    String Intento() throws RemoteException;
    String Sorteo(String Palabras[]) throws RemoteException;
    String Mensaje() throws RemoteException;
    String Jugando(String Letra) throws RemoteException;
    String MuestraVacios(String Palabras) throws RemoteException;
    String Victoria() throws RemoteException;

    
}
