/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Plataforma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
public class BancoCentral {

    public static void main(String[] args) {

        int port = 5001;

        String Mensaje;

        try {
            ServerSocket server = new ServerSocket(port);
            Socket client;
            PrintStream toClient;

            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Se Inicio el Servidor del Banco Central . . .");

            //Transformamos el String a un numero Entero
            Mensaje = fromClient.readLine();
            System.out.println("desde el Cliente -> " + Mensaje);

            toClient = new PrintStream(client.getOutputStream());

            toClient.println(Cotizacion(Mensaje));

            System.out.println("Mandando respuesta al Cliente . . .");

            System.out.println("Fin de la Conexion");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //Metodo para Introducir
    public static int Cotizacion(String Fecha) {
        return 7;
    }

    //Metodo que transforma de String a Entero
    public static int TextToNumber(String texto) {
        int Number = Integer.parseInt(texto);
        return Number;
    }

    //Metodo que transforma de String a Entero
    public static String NumberToText(int numero) {
        String Texto = String.valueOf(numero);
        return Texto;
    }

}
