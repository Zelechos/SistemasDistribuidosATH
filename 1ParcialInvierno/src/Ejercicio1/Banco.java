/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Banco {

  public static void main (String args[]) { 
    int port=6789;  
    try {
      
      DatagramSocket socketUDP = new DatagramSocket(port);
      byte[] bufer = new byte[1000];

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);
        System.out.println("Server Banco Activado");
        System.out.print("Datagrama recibido del host: " + peticion.getAddress());
        System.out.println(" desde el puerto remoto: " + peticion.getPort());
        System.out.println("datos : "+peticion.getData());
          
        //Convertimos de Bytes a String 
        String texto = new String(peticion.getData(), StandardCharsets.UTF_8);
        
        //esto te obliga a mandar en transformar en Bytes toda la 
        
        
        
          
        String Respuesta = String.valueOf(texto);
        System.out.println("resp : "+Respuesta);
        
        
        //Socket TCP CLIENTE CRENTRAL RIEGOS
        //----------------------------------------------------------------
        int puerto = 5001;
        String Mensaje = "";

        try {
            Socket client = new Socket("localhost", puerto);

            PrintStream toServer = new PrintStream(client.getOutputStream());

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            //Aqui mandamos el mensaje al Servidor
            String data = ReturnValue(Respuesta);
            toServer.println(data);
            
            System.out.println("-->"+data);

            //Aqui recibimos la respuesta del Servidor
            String result = fromServer.readLine();

            //Aqui mostramos la respueta del Servidor
            String MensajeServidor = result;
            System.out.println(MensajeServidor);

            Mensaje += MensajeServidor;
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        String MensajeCliente;
        if(Mensaje.equals("alto")){
           MensajeCliente = "Rechazado";
        }else{
            MensajeCliente = "Aprobado";
        }
        
        
        //----------------------------------------------------------------
        
        byte[] mensaje = MensajeCliente.getBytes();
        
        
        // Construimos el DatagramPacket para enviar la respuesta
        DatagramPacket respuesta = new DatagramPacket(mensaje, MensajeCliente.length() ,peticion.getAddress(), peticion.getPort());

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

  
  //Metodo para Tratamiento de String
  
    
     //Subrutina para Recuperar el valor de tipo entero donde "comando : valor-numero"
    public static String ReturnValue(String valor) {
        String[] Separado = valor.split("\\-");
        String text  = ReturnCarnetCliente(Separado[0].trim());
        return "riesgo:"+text;
    }
    
    //Subrutina para Recuperar el comando donde "comando : valor"
    public static String ReturnCarnetCliente(String comando) {
        String[] Separado = comando.split("\\:");
        return Separado[1].trim();
    }

}

    

