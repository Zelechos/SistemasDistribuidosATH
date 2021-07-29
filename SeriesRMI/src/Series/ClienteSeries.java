/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Series;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteSeries {

    public static void main(String[] args) {
        ISeries Serie;
        int Numbers[], Longitud, Opcion;

        Scanner Input = new Scanner(System.in);

        try {
            //Respuesta del servidor
            //Importamos nuestro RMI para el uso de sus Metodos
            Serie = (ISeries) Naming.lookup("rmi://localhost/Operaciones");

            //Menu .. 
            do {
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::MENU::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(":::::            1.- Sumatoria .                                                                                     :::::");
                System.out.println(":::::            2.- Factorial .                                                                                    :::::");
                System.out.println(":::::            3.- Fibonacci.                                                                                :::::");
                System.out.println(":::::            4.- Salir .                                                                                     :::::");
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.print("Digite una Opcion del Menu : ");
                Opcion = Input.nextInt();

                switch (Opcion) {
                    case 1:
                        //Le damos la longitud a los arrays dado que se realizaran operacion tiene que se la misma longitud
                        System.out.print("Introduzca la cantidad de elementos Vector Numbers para la Sumatoria : ");
                        Longitud = Input.nextInt();
                        Numbers = new int[Longitud];

                        for (int Iterador = 0; Iterador < Longitud; Iterador++) {
                            System.out.print("Elemento " + (Iterador + 1) + " del Vector Numbers : ");
                            Numbers[Iterador] = Input.nextInt();
                        }

                        System.out.print("La Sumatoria de : ");
                        for (int Iterador = 0; Iterador < Numbers.length; Iterador++) {
                            System.out.print(Numbers[Iterador] + " + ");
                        }
                        System.out.println("");

                        int Sumatoria = Serie.Sumatoria(Numbers);
                        System.out.println("La Sumatoria es ->" + Sumatoria);
                        break;
                    case 2:

                        System.out.print("Digite un numero para hallar su factorial : ");
                        int Number = Input.nextInt();
                        int factorial = Serie.Factorial(Number);

                        System.out.println("El Factorial es : " + factorial);

                        break;
                    case 3:

                        System.out.print("Digite un numero hasta donde sera la sucesion fibonacci : ");
                        int Number1 = Input.nextInt();

                        String resp = Serie.Fibonacci(Number1);
                        System.out.println("La Sucesion Fibonacci es : " + resp);
                        break;
                    case 4:
                        System.out.println(" Hasta Luego .. ");
                        break;
                    default:
                        System.out.println("ERROR NO EXISTE LA OPCION QUE INTRODUJO:");
                        break;
                }
            } while (Opcion != 4);

        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteSeries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteSeries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteSeries.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
