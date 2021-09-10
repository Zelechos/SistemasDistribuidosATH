/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        IGenerador Serie;
        int Opcion;

        Scanner Input = new Scanner(System.in);

        try {
            //Respuesta del servidor
            //Importamos nuestro RMI para el uso de sus Metodos
            Serie = (IGenerador) Naming.lookup("rmi://localhost/Operaciones");

            //Menu .. 
            do {
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::MENU::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(":::::            1.- Introducir .                                                                                     :::::");
                System.out.println(":::::            2.- Duplicar .                                                                                    :::::");
                System.out.println(":::::            3.- Aumentar Espacios.                                                                                :::::");
                System.out.println(":::::            4.- Mayuscula .                                                                                     :::::");
                System.out.println(":::::            5.- Salir .                                                                                     :::::");
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.print("Digite una Opcion del Menu : ");
                Opcion = Input.nextInt();

                switch (Opcion) {
                    case 1:
                        System.out.print("Introduzca una nueva cadena : ");
                        String cadena = Input.next();
                        if (Serie.introducirvalor(cadena)) {
                            System.out.println("La Cadena Tiene letras");
                        } else {
                            System.out.println("La Cadena esta Vacia no tiene letras");
                        }
                        
                        System.out.println(Serie.Show());      
                        break;
                    case 2:

                        String duplicado = Serie.duplicar();
                        System.out.println("La cadenas Duplicada es : \n" + duplicado);

                        break;
                    case 3:

                        System.out.print("Digite cuantos espacios agregar al texto : ");
                        int Number = Input.nextInt();

                        String resp = Serie.aumentarespacios(Number);
                        System.out.println("La Cadena con espacios aumentados es : \n" + resp);
                        break;
                    case 4:
                        String Text = Serie.mayuscula(Serie.Show());
                        System.out.println(Text);
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
