/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package SistemaPago;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteSSU {

    public static void main(String[] args) {
        IAfiliacion afiliacion;
        int Opcion;

        String CI , Nombres , Apellidos , fechanacimiento;
        Scanner Input = new Scanner(System.in);

        try {
            //Respuesta del servidor
            //Importamos nuestro RMI para el uso de sus Metodos
            afiliacion = (IAfiliacion) Naming.lookup("rmi://localhost/SSU");

            //Menu .. 
            do {
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::MENU::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(":::::            1.- Introducir Datos.                                                                                     :::::");
                System.out.println(":::::            2.- Duplicar .                                                                                    :::::");
                System.out.println(":::::            3.- Aumentar Espacios.                                                                                :::::");
                System.out.println(":::::            4.- Mayuscula .                                                                                     :::::");
                System.out.println(":::::            5.- Salir .                                                                                     :::::");
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.print("Digite una Opcion del Menu : ");
                Opcion = Input.nextInt();

                switch (Opcion) {
                    case 1:
                        System.out.print("Introduzca su CI: ");
                        CI = Input.next();
                        System.out.print("Introduzca sus Nombres : ");
                        Nombres = Input.next();
                        System.out.print("Introduzca sus apellidos : ");
                        Apellidos = Input.next();
                        System.out.print("Introduzca su fecha de nacimiento : ");
                        fechanacimiento = Input.next();
                        
                        afiliacion.SolicitarAfiliacion(CI, Nombres, Apellidos, fechanacimiento);
                        
                        System.out.println(afiliacion.Show());      
                        break;
                    case 2:
//
//                        String duplicado = afiliacion.duplicar();
//                        System.out.println("La cadenas Duplicada es : \n" + duplicado);

                        break;
                    case 3:

//                        System.out.print("Digite cuantos espacios agregar al texto : ");
//                        int Number = Input.nextInt();
//
//                        String resp = afiliacion.aumentarespacios(Number);
//                        System.out.println("La Cadena con espacios aumentados es : \n" + resp);
                        break;
                    case 4:
//                        String Text = afiliacion.mayuscula(afiliacion.Show());
//                        System.out.println(Text);
                        break;
                        
                    case 5:
                        System.out.println(" Hasta Luego .. ");
                        break;
                        
                    default:
                        System.out.println("ERROR NO EXISTE LA OPCION QUE INTRODUJO:");
                        break;
                }
            } while (Opcion != 5);

        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteSSU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteSSU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteSSU.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
