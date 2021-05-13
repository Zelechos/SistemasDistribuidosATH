package BNB;

import Juez.Cuenta;
import Juez.ServidorASFI;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorBNB  extends UnicastRemoteObject implements IBNB{

    static ArrayList<Cuenta> ListaBancoBNB = new ArrayList<>();
    Cuenta cuenta1 = new Cuenta("4657657", "11021654", "Juan Perez", "Segovia", 153214);

    public ServidorBNB()throws RemoteException{
        super();
    }
    
    
    public static void main(String[] args) {
        ServidorASFI servidor;  
      try {
	    LocateRegistry.createRegistry(5003); // registrar el servidor e rmi register
	    servidor= new ServidorASFI(); 
	    Naming.bind("BNB", servidor); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }

    @Override
    public ArrayList<Cuenta> ObtenerSaldo(String ci, String nombres, String apellidos) throws RemoteException {
        ListaBancoBNB.add(cuenta1);
        return ListaBancoBNB;
    }
            
    
    
}
