/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package RMI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) {
        int port = 5001 , opcion = 0;
        String Mensaje;
        Scanner input = new Scanner(System.in);
        
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            
    do {
            
            //Aqui pedimos al cliente que nos introduzca un Numero para Realizar el Factorial
            opcion = Integer.parseInt(JOptionPane.showInputDialog(" ---- MENU ----\n"
                        + "1 .- Introducir n \n"
                        + "2 .- Introducir Cadena\n"
                        + "3 .- Factorial\n"
                        + "4 .- Fibonacci.\n"
                        + "5 .- Invertir.\n"
                        + "6 .- Oracion.\n"
                        + "7 .- Salir."));

            
            
            if(opcion == 1){
                    System.out.println("Digite un Comando : ");
                    Mensaje = input.next();
                    toServer.println(Mensaje);
            }
            
            if(opcion == 2){
                    System.out.println("Digite un Comando : ");
                    Mensaje = input.next();
                    toServer.println(Mensaje);
            }
            if(opcion == 3){
                       System.out.println("Digite un Comando : ");
                    Mensaje = input.next();
                    toServer.println(Mensaje);
            }
            
            if(opcion == 4){
                System.out.println("Digite un Comando : ");
                    Mensaje = input.next();
                    toServer.println(Mensaje);
            }
                
                if(opcion == 5){
                                        System.out.println("Digite un Comando : ");
                    Mensaje = input.next();
                    toServer.println(Mensaje);
                }
            if(opcion == 6){
                        
                System.out.println("Digite un Comando : ");
                    Mensaje = input.next();
                    toServer.println(Mensaje);
                    }
             
            if(opcion == 7){
                toServer.println("FIN");
                JOptionPane.showMessageDialog(null, "Fin del Programa");
                 System.exit(0);
            }
                        

            
            //Aqui recibimos la respuesta del Servidor
            String result = fromServer.readLine();  
            
            //Aqui mostramos la respueta del Servidor
            System.out.println("Mensaje del Servidor --> " + result);
            
            } while (opcion != 7);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
