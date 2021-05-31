/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) {
        int port = 5001 ;
        String resp = "Respuesta",Mensaje ="", cadena1, cadena2, cadena3, a = "-a" ,b = "-b" ,c = "-c",result="" ,result1;

        do{
        try {
            Socket client = new Socket("localhost", port); 

            PrintStream toServer = new PrintStream(client.getOutputStream());
            
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            
            //Aqui pedimos al cliente que nos introduzca los datos que se usaran para enviar al servidor
            
            cadena1 = Data();
            cadena2 = Data();
            cadena3 = Data();
            Mensaje += cadena1.concat(a)+","+cadena2.concat(b)+","+cadena3.concat(c);
            
            //Aqui mandamos el Numero al Servidor
            toServer.println(Mensaje);
            String text = Mensaje.concat("OK");
            //Aqui recibimos la respuesta del Servidor
            result = fromServer.readLine();  
            
            //Aqui mostramos la respueta del Servidor
            System.out.println("Mensaje del Servidor --> " + result);
            
            //Enviamos el comando Respuesta para que no envie el numero mayor del mensaje
            toServer.println(resp);
            result = fromServer.readLine();  
            System.out.println("Mensaje del Servidor --> El mayor es : " + result);
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        }while(result.equals(Mensaje));
        
    }
    
    public static String Data(){
        int Numero ;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite un Numero :");
        Numero = input.nextInt();
        //Transformamos el numero en String
        String Texto = String.valueOf(Numero);
        return Texto;
    }
    
}
