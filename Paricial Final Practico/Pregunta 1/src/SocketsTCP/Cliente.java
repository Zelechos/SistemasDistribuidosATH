/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package SocketsTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente {
    static String Mensaje;

    public static void main(String[] args) {
        int port = 5001 , opcion;
        Scanner input = new Scanner(System.in);
        
        try {
    do {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            //Aqui pedimos al cliente que nos introduzca un Numero para Realizar el Factorial
           System.out.print(" ---- MENU ----\n"
                        + "1 .- Introducir n \n"
                        + "2 .- Introducir Cadena\n"
                        + "3 .- Factorial\n"
                        + "4 .- Fibonacci.\n"
                        + "5 .- Invertir.\n"
                        + "6 .- Oracion.\n"
                        + "7 .- Salir.\n"
           +"Opcion : "); 
            opcion = input.nextInt();
            
            
            if(opcion < 7){
                    System.out.println("Digite un Comando : ");
                    Mensaje = input.next();
            }
             
            if(opcion == 7){
                toServer.println("FIN");
                JOptionPane.showMessageDialog(null, "Fin del Programa");
                System.exit(0);
            }
    
            toServer.println(Mensaje);

            
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
