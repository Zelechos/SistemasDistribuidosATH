/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Universidad;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteUniversidadRMI {

    public static void main(String[] args) {
        
          EmitirDiplomas Tramite;
        
          String CI, Nombres, Apellido_Paterno, Apellido_Materno, Fecha_Nacimiento, Carrera, Vacio="";
        try {
            
            Tramite = (EmitirDiplomas) Naming.lookup("rmi://localhost/ServerUniversidad");
            
            CI = Inputs("CI");
            Nombres = Inputs("Nombre o Nombres");
            Apellido_Paterno = Inputs("Apellido Paterno");
            Apellido_Materno = Inputs("Apellido Materno");
            Fecha_Nacimiento = Inputs("Fecha de Nacimiento");
            Carrera = Inputs("Carrera");
            
            Diplomado Diploma = Tramite.EmitirDiploma(CI, Nombres, Apellido_Paterno, Apellido_Materno, Carrera, Fecha_Nacimiento);

            
            if (Vacio.equals(Diploma.getMensaje())) {
                
                System.out.println("--- Datos Diploma ---");
                
                System.out.println("Mensaje: " + Diploma.getMensaje());
                
                System.out.println("Nombre completo: " + Diploma.getNombreCompleto());
                System.out.println("Carrera: " + Diploma.getCarrera());
                System.out.println("Fecha: " + Diploma.getFecha());
                
            } else {
                //Mensaje Respuesta de los Servidores
                System.out.println("Mensaje: " + Diploma.getMensaje());
                System.out.println(ServidorUniversidadRMI.MensajeSeduca);
                System.out.println(ServidorUniversidadRMI.MensajeSereci);

            }
            
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
        
        
        
    }
    
    //Metodo para Introducir los Datos Dinamicamente
    public static String Inputs(String DataNames) {
        Scanner Input = new Scanner(System.in);
        System.out.print("Introduzca " + DataNames+" : ");
        return Input.nextLine().toLowerCase();
    }
    
    
    
}
