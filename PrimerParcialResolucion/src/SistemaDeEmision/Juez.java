package SistemaDeEmision;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juez {
    
    public static void main(String[] args) throws NotBoundException {
        IConexion asfi;
        
        try {
            ArrayList <String> textos;
            asfi = (IConexion)Naming.lookup("rmi://localhost/ASFI");
            
            textos = asfi.testingServicios();
            System.out.println(textos.get(0));
            
        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
            
    
}
