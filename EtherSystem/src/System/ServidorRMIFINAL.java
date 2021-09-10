package System;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorRMIFINAL extends UnicastRemoteObject implements IFinal {

    //Atributos
    
    //Metodos de la Clase
    public ServidorRMIFINAL() throws RemoteException {
        super();
    }
    
    //Para enviar al cliente la Palabra Escogida
    @Override
    public String Mensaje() throws RemoteException {
        return "<--Servidor RMI Final activo-->";
    }
       
  public static void main(String[] args) {
       ServidorRMIFINAL servidor;  
      try {
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            
	    servidor = new ServidorRMIFINAL(); 
            
	    Naming.bind("RMIFINAL", servidor); 
            System.out.println("El servidor RMI_FINAL esta listo\n");
            
        }catch (MalformedURLException | AlreadyBoundException | RemoteException e){}
    }
   
}

