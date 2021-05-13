/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package BancoBCP;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ServidorBancoBCP extends Thread{

    public static void main(String[] args) {
         int port=6789;  
         String Palabras[];
    
        try {

          DatagramSocket socketUDP = new DatagramSocket(port);
          byte[] bufer = new byte[1000];

          while (true) {
            // Construimos el DatagramPacket para recibir peticiones
            DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

            // Leemos una petición del DatagramSocket
            socketUDP.receive(peticion);
            System.out.println("<Mensaje del Servidor Sereci>");

            System.out.print("Datagrama recibido del host: " + peticion.getAddress());
            System.out.println(" desde el puerto remoto: " + peticion.getPort());

            //Convertimos de Bytes a String 
            String Ver_Fecha = new String(peticion.getData(), StandardCharsets.UTF_8);


            //Metodo para realizar
            
            Palabras = TextoAVector(Ver_Fecha);
            String Respuesta = GeneradorMensaje(Palabras);
            
            //Convertimos de Entero A String
            System.out.println("resp : "+Respuesta);

            //Convertimos de String a Bytes 
            byte[] mensaje = Respuesta.getBytes();


            // Construimos el DatagramPacket para enviar la respuesta
            DatagramPacket respuesta = new DatagramPacket(mensaje, Respuesta.length() ,peticion.getAddress(), peticion.getPort());

            // Enviamos la respuesta, que es un eco
            socketUDP.send(respuesta);
            socketUDP.close();
          }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        
    }
    
    public static String[] TextoAVector(String DatosUsuario){
        String [] Vector = DatosUsuario.split(",");
        return Vector;
    }
    
    
    public static String GeneradorMensaje(String Palabras[]){
        String Nombre_Valido = "walter jhamil", 
                Apellidos_Valido = "segovia arellano",
                Fecha_Nacimiento = "11-02-1996";
        if (Palabras[0].trim().equals(Nombre_Valido) && Palabras[1].trim().equals(Apellidos_Valido) && Palabras[2].trim().equals(Fecha_Nacimiento)) {
            return "verificación correcta ";
        }
        return "error fecha nacimiento no correcta";    
        
    }
    
}
