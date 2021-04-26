/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Operaciones;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorOperaciones extends UnicastRemoteObject implements IOperaciones {

    public ServidorOperaciones() throws RemoteException {
        super();
    }

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    };
    
  public static void main(String[] args) {
       ServidorOperaciones servidor;  
      try {
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
	    servidor=new ServidorOperaciones(); 
	    Naming.bind("Operaciones", servidor); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }
}
