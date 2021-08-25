package SistemaDeEmision;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BancoBNB extends UnicastRemoteObject implements IConexionBNB{
     //Metodos de la Clase
    public BancoBNB() throws RemoteException {
        super();
    }
    
    @Override
    public ArrayList<Cuenta> ObtenerSaldo(String CI, String Nombres, String Apellidos) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String testing() throws RemoteException{
        return "El Servidor del BancoBNB Funciona !!";
    }
    
    public static void main(String[] args){
        BancoBNB servidor;  
        try {
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
	
            servidor = new BancoBNB(); 
            
            Naming.bind("BANCOBNB", servidor);
            System.out.println("<Mensaje del Servidor BNB>");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {}
    }

    
    
}
