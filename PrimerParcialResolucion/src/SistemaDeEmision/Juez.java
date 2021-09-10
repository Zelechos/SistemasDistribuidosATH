package SistemaDeEmision;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Juez {
    
    public static void main(String[] args){
        IConexion asfi;
        
        try {
            ArrayList<String> Bancos = new ArrayList<>();
            asfi = (IConexion)Naming.lookup("rmi://localhost/ASFI");
            
            Bancos = asfi.testingServicios();
            System.out.println(Bancos.get(0));
            System.out.println(Bancos.get(1));
            System.out.println(Bancos.get(2));
            
        } catch (MalformedURLException | RemoteException | NotBoundException ex) {}
        
    }
            
            
    
}
