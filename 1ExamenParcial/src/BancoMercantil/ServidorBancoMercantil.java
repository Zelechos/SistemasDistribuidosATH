package BancoMercantil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBancoMercantil extends Thread{
    
     public static void main(String[] args) {
        
        int port = 5001; 
        String Datos_Usuario, ComandoPalabra[] , Palabras[];
       
        try {
            ServerSocket server = new ServerSocket(port);
            
            System.out.println("<Mensaje del Servidor Banco Mercantil>");
            Socket client;
            PrintStream toClient;       
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            
            //Transformamos el String a un numero Entero
            Datos_Usuario = fromClient.readLine();
            System.out.println(Datos_Usuario);
            
            ComandoPalabra = TextoAVector(Datos_Usuario);
            Palabras = TextoAPalabras(ComandoPalabra[1]);
            
            toClient = new PrintStream(client.getOutputStream()); 
            
            //Instanciamos el Metodo Estatico Factorial y mostramos el resultado de la del Factorial
            toClient.println();
            
            System.out.println("Mandando respuesta al Cliente . . .");
            System.out.println("Fin de la Conexion");
            
        } catch (IOException e) {
            System.out.println("COnexion seduca fallo");
            System.out.println(e.getMessage());
        }
  
    }
     
     
    public static String[] TextoAVector(String DatosUsuario){
        String [] Vector = DatosUsuario.split(":");
        return Vector;
    } 
     
    public static String[] TextoAPalabras(String DatosUsuario){
        String [] Vector = DatosUsuario.split("-");
        return Vector;
    }
    
}
