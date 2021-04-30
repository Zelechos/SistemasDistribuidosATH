package Segip;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorSegipRMI extends UnicastRemoteObject implements VerificacionDeDatos {
    
    public static void main(String[] args) {
        ServidorSegipRMI Server;
        try {
            LocateRegistry.createRegistry(5002); // registrar el servidor e rmi register
            Server = new ServidorSegipRMI();
            Naming.bind("ServerSegip", Server);
            System.out.println("El servidor SEGIP esta listo\n");
        } catch (MalformedURLException | RemoteException | AlreadyBoundException ex) {
            System.out.println(ex);
        }
    }
    
    public ServidorSegipRMI() throws RemoteException {
        super();
    }

    @Override
    public Respuesta VerificarDatos(String CI, String Nombre, String Apellidos) {
        //Testeamos los datos
        String CI_Valido = "1", Nombre_Valido = "x", Apellidos_Valido = "y z";
        
        if (CI.equals(CI_Valido) && Nombre.equals(Nombre_Valido) && Apellidos.equals(Apellidos_Valido)) {
            return new Respuesta(true, "Los datos son Correctos");
        }
        return new Respuesta(false, "Los Datos del CI no son correctos");
    }

    
    
}
