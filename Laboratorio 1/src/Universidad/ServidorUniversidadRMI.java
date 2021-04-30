package Universidad;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorUniversidadRMI extends UnicastRemoteObject implements  EmitirDiploma{

    public static void main(String[] args) {
        ServidorUniversidadRMI Server;
        try {
            //LocateRegistry.createRegistry(1231); // registrar el servidor e rmi register
            Server = new ServidorUniversidadRMI();
            Naming.bind("ServidorUniversidad", Server);
            System.out.println("El servidor UNIVERSIDAD esta listo\n");
        } catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
            System.out.println(e);
        }
        
    }

    
    @Override
    public Diplomado EmitirDiploma(String CI, String Nombre, 
            String Apellido_Paterno, String Apellido_Materno, 
            String Carrera, String Fecha_Nacimiento) 
            throws RemoteException {
        
        
        
        //Instancia del Diplomado
        Diplomado Instance = new Diplomado("dale","vamos","joda","vamos");
        
        return Instance;
    }
    
}
