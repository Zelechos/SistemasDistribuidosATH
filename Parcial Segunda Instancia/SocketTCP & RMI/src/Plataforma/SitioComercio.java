/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Plataforma;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SitioComercio {

    public static void main(String[] args) {
        ITransaccion transaccion;
        Scanner Input = new Scanner(System.in);
        String NroCuenta , CuentaVendedor , Moneda;
        int Monto , Opcion;
        //LLenamos los arrays A & B
        
        try {
            //Respuesta del servidor
            transaccion = (ITransaccion)Naming.lookup("rmi://localhost/Transaccion");
            
            //Empezamos con el Juego 
            System.out.println("[---Bienvenido ---]");
            System.out.print("Digite su Numero de Cuenta : ");
            NroCuenta = Input.next();
            
            System.out.print("Digite su Cuenta Vendedor : ");
            CuentaVendedor = Input.next();
            
            System.out.print("Seleccione una Moneda : (Dolar , Boliviano)");
            Moneda = Input.next();
            
            
            System.out.print("Digite el monto : ");
            Monto = Input.nextInt();
            
            transaccion.realizarTransaccion(NroCuenta, CuentaVendedor, Monto , Moneda);
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(SitioComercio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SitioComercio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SitioComercio.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
    
}
