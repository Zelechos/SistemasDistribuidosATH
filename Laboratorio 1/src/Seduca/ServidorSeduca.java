/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Seduca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSeduca extends Thread{

        
    public static void main(String[] args) {
        
        int port = 5001; 
        String Datos_Usuario,RUDE;
       
        try {
            ServerSocket server = new ServerSocket(port);
            
            System.out.println("<Mensaje del Servidor Seduca>");
            Socket client;
            PrintStream toClient;       
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            
            //Transformamos el String a un numero Entero
            Datos_Usuario = fromClient.readLine();
            System.out.println(Datos_Usuario);
            String  Palabras[] = TextoAVector(Datos_Usuario);
            
            RUDE = Rude(Palabras);
            System.out.println(RUDE);
            
            toClient = new PrintStream(client.getOutputStream()); 
            
            //Instanciamos el Metodo Estatico Factorial y mostramos el resultado de la del Factorial
            toClient.println(Testing(RUDE));
            
            System.out.println("Mandando respuesta al Cliente . . .");
            System.out.println("Fin de la Conexion");
            
        } catch (IOException e) {
            System.out.println("COnexion seduca fallo");
            System.out.println(e.getMessage());
        }
  
    }
    
    public static String Testing(String Rude){
        String rudeuser = "wasear11021996";
        if(Rude.equals(rudeuser)){
            return "verificado con éxito";
        }
        return "no se encontró el titulo de bachiller";
    }
    
    public static String Rude(String Palabras[]){
        return DosLetras(Palabras[0])+DosLetras(Palabras[1])+DosLetras(Palabras[2])+FechaTexto(Palabras[3]);
    }
    
    public static String DosLetras(String cadena) {
        if (cadena.length() < 2) {
            return cadena.substring(0) + "";
        }
        return cadena.substring(0, 2);
    }
    
    
    public static String FechaTexto(String fecha){
        return fecha.replace("-", "");
    }
    
    
    public static String[] TextoAVector(String DatosUsuario){
        String [] Vector = DatosUsuario.split(",");
        return Vector;
    }

    

}
