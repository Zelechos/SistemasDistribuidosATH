/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Universidad;

import Seduca.ServidorSeduca;
import Segip.VerificacionDeDatos;
import Segip.Respuesta;
import Sereci.ServidorSereci;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorUniversidadRMI extends UnicastRemoteObject implements EmitirDiplomas {

    //Variables Globales
    public static String Datos_Usuario, Data_Fecha, MensajeSereci, MensajeSeduca;
    public static ArrayList<String> mensajes = new ArrayList<String>();

    public ServidorUniversidadRMI() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        ServidorUniversidadRMI Server;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            Server = new ServidorUniversidadRMI();
            Naming.bind("ServerUniversidad", Server);
            System.out.println("El servidor UNIVERSIDAD esta listo\n");
        } catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
            System.out.println(e);
        }

        //Iniciando conexion con el servidor seduca
        Seduca();

        //Iniciando conexion con el servidor sereci
        Sereci();

    }

    public static void Sereci() {
        ServidorSereci hilo1 = new ServidorSereci();
        try {
            ServidorSereci.sleep(10000);
            hilo1.start();
            ConexionSereci();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServidorUniversidadRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ConexionSereci() {
        int puerto = 6789;
        String Ver_Fecha = Data_Fecha;
        try {

            //Pedimos el dato que enviaremos al servidor
            String ip = "localhost";

            //Convertimos de String a Bytes
            try (DatagramSocket socketUDP = new DatagramSocket()) {
                //Convertimos de String a Bytes
                System.out.println("Se inicio el Servidor Sereci");

                byte[] Mensaje = Ver_Fecha.getBytes();
                InetAddress hostServidor = InetAddress.getByName(ip);
                // Construimos un datagrama para enviar el mensaje al servidor
                DatagramPacket peticion = new DatagramPacket(Mensaje, Ver_Fecha.length(), hostServidor, puerto);
                // Enviamos el datagrama
                socketUDP.send(peticion);
                // Construimos el DatagramPacket que contendrá la respuesta
                byte[] bufer = new byte[1000];
                DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(respuesta);
                // Enviamos la respuesta del servidor a la salida estandar
                MensajeSereci = "Mensaje del Servidor Sereci --> " + new String(respuesta.getData());
                System.out.println(MensajeSereci);

            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public static void Seduca() {
        ServidorSeduca hilo = new ServidorSeduca();
        try {
            ServidorSeduca.sleep(50000);
            hilo.start();
            ConexionSeduca();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServidorUniversidadRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ConexionSeduca() {
        //LLamando al Servidor del Seduca
        int port = 5001;
        String Verificar_Rude = Datos_Usuario;

        try {
            Socket client = new Socket("localhost", port);
            System.out.println("Se inicio el Servidor Seduca");

            PrintStream toServer = new PrintStream(client.getOutputStream());

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            //Aqui mandamos el mensaje al Servidor
            toServer.println(Verificar_Rude);

            //Aqui recibimos la respuesta del Servidor
            String result = fromServer.readLine();

            //Aqui mostramos la respueta del Servidor
            MensajeSeduca = "Mensaje del Servidor Seduca --> " + result;
            System.out.println(MensajeSeduca);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo para obetener la Fecha del Sistema
    public static String Fecha() {
        Calendar Fechas = new GregorianCalendar();
        int Year, Month, Day;
        String Fecha_Actual;

        Year = Fechas.get(Calendar.YEAR);
        Month = Fechas.get(Calendar.MONTH);
        Day = Fechas.get(Calendar.DAY_OF_MONTH);

        //Generamos la Fecha Actual
        Fecha_Actual = String.format(" %d-%d-%d ", Day, Month + 1, Year);

        return Fecha_Actual;
    }

    //Metodo para generar el Apellido Completo
    public static String Apellidos(String ApellidoPaterno, String ApellidoMaterno) {
        String Apellido = String.format("%s %s", ApellidoPaterno, ApellidoMaterno);
        return Apellido;
    }

    //Metodo para generar el Nombre Completo
    public static String NombreCompleto(String Nombre, String Apellidos) {
        String Nombre_Completo = String.format("%s %s", Nombre, Apellidos);
        return Nombre_Completo;
    }

    public static String DataUser(String Nombre, String Apellido_Paterno, String Apellido_Materno, String CI) {
        return Nombre + "," + Apellido_Paterno + "," + Apellido_Materno + "," + CI;
    }

    public static String DataUser(String Nombre, String Apellidos, String Fecha) {
        return Nombre + "," + Apellidos + "," + Fecha;
    }

    @Override
    public Diplomado EmitirDiploma(String CI,
            String Nombre,
            String Apellido_Paterno,
            String Apellido_Materno,
            String Carrera,
            String Fecha_Nacimiento) throws RemoteException {

        VerificacionDeDatos Segip;
        String Apellido_Completo = Apellidos(Apellido_Paterno, Apellido_Materno);
        String Nombre_Completo = NombreCompleto(Nombre, Apellido_Completo);
        
        //Generamos la fecha actual del sistema 
        String Fecha = Fecha();

        //LLamando al Servidor del Segip
        mensajes.add("Los datos son Correctos");
        mensajes.add("Los Datos del CI no son correctos");
        try {

            Segip = (VerificacionDeDatos) Naming.lookup("rmi://localhost/ServerSegip");
            Respuesta Respuesta_Segip = Segip.VerificarDatos(CI, Nombre, Apellido_Completo);

            if (!Respuesta_Segip.getEstado_Respuesta()) {
                mensajes.add(Respuesta_Segip.getMensaje());
            }

            // Generamos el String NombreCompleto
            //Instancia del Diplomado
            //Generamos El Rude del Usuario
            String Datos = DataUser(Nombre, Apellido_Paterno, Apellido_Materno, Fecha_Nacimiento);
            Datos_Usuario = Datos;

            //Guardamos datos en un texto para enviar al servidor SERECI
            String Data = DataUser(Nombre, Apellido_Completo, Fecha_Nacimiento);
            Data_Fecha = Data;

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }

        if (Nombre_Completo.equals("Walter s Jhamil Segovia Arellano")) {
            return new Diplomado(Nombre_Completo, Carrera, Fecha, mensajes.get(0));
        } else {
            return new Diplomado(Nombre_Completo, Carrera, Fecha, mensajes.get(1));
        }

    }

}
