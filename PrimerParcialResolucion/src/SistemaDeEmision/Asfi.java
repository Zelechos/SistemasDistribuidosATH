package SistemaDeEmision;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Asfi extends UnicastRemoteObject implements IConexion {

    //Metodos de la Clase
    public Asfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ListaCuentas(String CI, String Nombres, String Apellidos) throws RemoteException {
        ArrayList<Cuenta> ether = new ArrayList<>();
        return ether;
    }

    @Override
    public boolean RetenerMonto(Cuenta cuenta, double Monto) throws RemoteException {
        //El cliente juez nos tiene que pasar la cuenta y el monto a retener despues de elejir el banco

        //aqui retornamos true o falso dependiendo si se encontro la retencion
        return true;
    }

    //Metodos Alternos
    public ArrayList<Cuenta> ObtenerCuentas() {
        ArrayList<Cuenta> ether = new ArrayList<>();

        //Este arraylist tiene que tener las cuentas y sus saldos de los tres bancos
        return ether;
    }

    //Subrutina para mandar los datos al cliente juez y ver si funciona los metodos
    @Override
    public ArrayList<String> testingServicios() throws RemoteException{
        ArrayList<String> Bancos = new ArrayList<>();
        try {
            String text= BNB_Cliente();
            Bancos.add(text);
            System.out.println("text -> " +text);
        } catch (NotBoundException ex) {
            Logger.getLogger(Asfi.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Bancos.add(BancoMercantil_Cliente());
//        Bancos.add(BancoBCP_Cliente());
        return Bancos;
    }

    //Cliente RMI BNB
    public String BNB_Cliente() throws NotBoundException {
        IConexionBNB BNB;
        String response = "";
        try {

            BNB = (IConexionBNB) Naming.lookup("rmi://localhost/BNB");

            response += BNB.testing();
            System.out.println("response -> "+response);

        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    //Cliente Banco Mecantil con socket TCP
    public String BancoMercantil_Cliente() {
        //LLamando al Servidor del BAnco Mercantil
        int port = 5001;
        String Mensaje = "";
//        Mensaje += Lista.get(0).CI+"-"+Lista.get(0).Nombres+"-"+Lista.get(0).Apellido;

        try {
            Socket client = new Socket("localhost", port);
            System.out.println("Se inicio el Servidor Banco Mercantil");

            PrintStream toServer = new PrintStream(client.getOutputStream());

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            //Aqui mandamos el mensaje al Servidor
            toServer.println(Mensaje);

            //Aqui recibimos la respuesta del Servidor
            String result = fromServer.readLine();

            //Aqui mostramos la respueta del Servidor
            String MensajeServidor = result;
            System.out.println(MensajeServidor);

            Mensaje += MensajeServidor;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return Mensaje;

    }

    //Cliente Banco BCP socket UDP
    public String BancoBCP_Cliente() {
        int puerto = 6789;
        String response = "", response1 = "";
        try {

            //Pedimos el dato que enviaremos al servidor
            String ip = "localhost";

            //Convertimos de String a Bytes
            try (DatagramSocket socketUDP = new DatagramSocket()) {
                //Convertimos de String a Bytes
                System.out.println("Se inicio el Servidor Sereci");

                byte[] Mensaje = response.getBytes();
                InetAddress hostServidor = InetAddress.getByName(ip);
                // Construimos un datagrama para enviar el mensaje al servidor
                DatagramPacket peticion = new DatagramPacket(Mensaje, response.length(), hostServidor, puerto);
                // Enviamos el datagrama
                socketUDP.send(peticion);
                // Construimos el DatagramPacket que contendrá la respuesta
                byte[] bufer = new byte[1000];
                DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(respuesta);

                // Enviamos la respuesta del servidor a la salida estandar
                String MensajeSereci = new String(respuesta.getData());
                System.out.println(MensajeSereci);
                response1 += MensajeSereci;

                return response1;
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        return response1;
    }

    public static void main(String[] args) {
        Asfi servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new Asfi();
            Naming.bind("ASFI", servidor);
            System.out.println("El Servidor ASFI esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
        }
    }

}
