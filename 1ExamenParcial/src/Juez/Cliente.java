package Juez;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    
    public static void main(String[] args) {
        IJuez user;
        Scanner Input = new Scanner(System.in);
        int intentos = 5 ;
        String letra;
        
        try {
            user = (IJuez)Naming.lookup("rmi://localhost/ASFI");
            
            System.out.println(user.ListaCuentas("11021654", "Juan Perez", "Segovia"));
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
    
    
}
