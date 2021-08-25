/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CentralRiesgos {
    
    
    public static void main(String[] args) {
        //Creamos dos diferentes puertos en los cuales trabajaremos varios clientes
        int port1 = 5001;
        
        String Texto,Texto1;

        try {
            //Creamos los servidores para ambos clientes
            
            //Servidor 1
            ServerSocket server = new ServerSocket(port1);
            System.out.println("Server Central de Riesgos Activado");
            
            //Instanciamos un objeto de la clase 
            CentralRiesgos servidor = new CentralRiesgos();
            
            //creamos clientes y los mensajes hacie los cliente4s
            Socket client;
            PrintStream toClient;       
            
            client = server.accept(); //conexion port5001
            
            //Recibimos la palabra del cliente 1
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            
            //Pasamos el mensaje del Cliente 1 a la Variable Texto
            Texto = fromClient.readLine();
            
            String Respuesta = RespuestaRiesgo(ReturnCarnetCliente(Texto));
            

            //Instanciamos a ambos clientes
            toClient = new PrintStream(client.getOutputStream()); 


            //Mensaje que enviamos al cliente 0 que es la palabra para trabajar con ella
            toClient.println(Respuesta);
            
            

            System.out.println("Fin de la Conexion");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
  
    }
    
    //Metodo para encriptar la Palabra

    //Para enviar un mensaje al cliente como se esta llenando la palabra
    public static String RespuestaRiesgo(String Mensaje) {
        
        if(Mensaje.equals("12345")){
            return "bajo";
        }
        
        if(Mensaje.equals("56789")){
            return "medio";
        }
        
        return "alto";
        
    }
    
    //Subrutina para Recuperar el comando donde "comando : valor"
    public static String ReturnCarnetCliente(String comando) {
        String[] Separado = comando.split("\\:");
        return Separado[1].trim();
    }
    
}
