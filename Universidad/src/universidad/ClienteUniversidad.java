/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package universidad;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUniversidad {

    public static void main(String[] args) {
        IUniversidad universidad;
        String Vacio = "";
        String CI = "1140506";
        String Nombre = "Walter Jhamil";
        String Apellido_Paterno = "Segovia";
        String Apellido_Materno = "Arellano";
        String Carrera = "Ing. en Ciencias de la Computacion";
        String Fecha = "11-02-1996";
        int Opcion;

        Scanner Input = new Scanner(System.in);

        try {
            //Respuesta del servidor
            //Importamos nuestro RMI para el uso de sus Metodos
            universidad = (IUniversidad) Naming.lookup("rmi://localhost/Universidad");

            //Menu .. 
            do {
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::MENU::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(":::::            1.- Emitir Diploma .                                                                                     :::::");
                System.out.println(":::::            2.- .                                                                                    :::::");
                System.out.println(":::::            3.- Mostrar.                                                                                :::::");
                System.out.println(":::::            4.- Salir .                                                                                     :::::");
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.print("Digite una Opcion del Menu : ");
                Opcion = Input.nextInt();

                switch (Opcion) {
                    case 1:
                        System.out.println("LLenando sus datos personales ... ");

//                        CI = Inputs("CI");
//                        Nombre = Inputs("Nombre o Nombres");
//                        Apellido_Paterno = Inputs("Apellido Paterno");
//                        Apellido_Materno = Inputs("Apellido Materno");
//                        Fecha = Inputs("Fecha de Nacimiento");
//                        Carrera = Inputs("Carrera");
                        Diploma diploma = universidad.EmitirDiploma(CI, Nombre, Apellido_Paterno, Apellido_Materno, Fecha, Carrera);

                        if (Vacio.equals(diploma.getMensaje())) {

                            System.out.println("--- Datos Diploma ---");

                            System.out.println("Mensaje: " + diploma.getMensaje());

                            System.out.println("Nombre completo: " + diploma.getNombreCompleto());
                            System.out.println("Carrera: " + diploma.getCarrera());
                            System.out.println("Fecha: " + diploma.getFecha());

                        }

                        System.out.println("REspuseta -> " + diploma.getMensaje());

                        break;
                    case 2:

                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println(" Hasta Luego .. ");
                        break;
                    default:
                        System.out.println("ERROR NO EXISTE LA OPCION QUE INTRODUJO:");
                        break;
                }
            } while (Opcion != 4);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Metodo para Introducir los Datos Dinamicamente
    public static String Inputs(String DataNames) {
        Scanner Input = new Scanner(System.in);
        System.out.print("Introduzca " + DataNames + " : ");
        return Input.nextLine().toLowerCase();
    }

}
