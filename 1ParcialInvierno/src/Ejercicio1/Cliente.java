/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {

    // Los argumentos proporcionan el mensaje y el nombre del servidor
    public static void main(String args[]) {
        int puerto = 6789;
        String Carnet, Monto;
        Scanner input = new Scanner(System.in);
        try {

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::MENU::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("<----Bienvenido a su Banco Online----->");
            System.out.print("Digite Carnet de Identidad (124972): ");
            Carnet = input.next();
            System.out.print("Digite El monto que desea como prestamo : ");
            Monto = input.next();
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

            String Mensaje = "credito" + ":" + Carnet + "-" + Monto;

            //Bloque de envio del Datagrama
            String ip = "localhost";

            DatagramSocket socketUDP = new DatagramSocket();

            //esto te obliga a mandar en transformar en Bytes toda la 
            byte[] mensaje = Mensaje.getBytes();

            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion = new DatagramPacket(mensaje, Mensaje.length(), hostServidor, puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);

            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            System.out.println("Su Credito a Sido : " + new String(respuesta.getData()));

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
