package System;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorRMI extends UnicastRemoteObject implements IMensajeRMI {

    //Metodos de la Clase
    public ServidorRMI() throws RemoteException {
        super();
    }

    //Para enviar al cliente la Palabra Escogida
    @Override
    public String MensajeRMI() throws RemoteException {
            
        //Cliente RMI
        IFinal ServidorRMI;
        String mensajeRMIFINAL = "";

        try {
            ServidorRMI = (IFinal) Naming.lookup("rmi://localhost/RMIFINAL");
            System.out.println(ServidorRMI.Mensaje());
            mensajeRMIFINAL += ServidorRMI.Mensaje();
            
        }catch (NotBoundException | MalformedURLException | RemoteException ex) {} 
        
        return "<--Servidor RMI activo-->"+"Mensaje del RMIFINAL -> "+mensajeRMIFINAL;
    }

    public static void main(String[] args){
        
        //Servidor RMI
        ServidorRMI servidor;
        try {
            LocateRegistry.createRegistry(4444); // registrar el servidor e rmi register

            servidor = new ServidorRMI();

            Naming.bind("RMI", servidor);
            System.out.println("El servidor RMI esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {}
        
    }

}
