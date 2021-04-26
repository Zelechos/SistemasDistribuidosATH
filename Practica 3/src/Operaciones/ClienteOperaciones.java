/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Operaciones;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteOperaciones {

    public static void main(String[] args) {
        IOperaciones operacion;
        int a;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.println("introduzca el valor de A");
        a=sc.nextInt();
        System.out.println("introduzca el valor de B");
        b=sc.nextInt();
        
        try {
            operacion = (IOperaciones)Naming.lookup("rmi://localhost/Operaciones");
            int c= operacion.sumar(a, b);
            System.out.print("La suma es"+c);
            
            
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
