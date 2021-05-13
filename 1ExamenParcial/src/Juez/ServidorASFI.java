package Juez;

import BNB.IBNB;
import BancoBCP.ServidorBancoBCP;
import BancoMercantil.ServidorBancoMercantil;
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

public class ServidorASFI extends UnicastRemoteObject implements IJuez{

    static ArrayList<Cuenta> ListaBancoBNB = new ArrayList<>();
    static ArrayList<Cuenta> ListaBancoBCP = new ArrayList<>();
    static ArrayList<Cuenta> ListaBancoMercantil = new ArrayList<>();
    
    static ArrayList<Cuenta> ListaAux = new ArrayList<>();
    
    static ArrayList<Cuenta> Lista = new ArrayList<>();

    Cuenta cuenta1 , cuenta2, cuenta3;
    
    public ServidorASFI()throws RemoteException{
        super();
    }
    
    
    @Override
    public ArrayList<Cuenta> ListaCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        
        ListaAux = BNB();
        cuenta1 = ListaAux.get(0);
        Lista.add(cuenta1);
        ListaAux.clear();
        
        
        Lista.add(cuenta2);
        Lista.add(cuenta3);
        
        return Lista;
    }

    @Override
    public boolean RetenerMonto(Cuenta cuenta, int monto, String glosa) throws RemoteException {
        return false;
    }
    
    
    public static void main(String[] args) {
    //Conectamos con el cliente juez 
      Cliente();
      
      //Conectamos como cliente al Banco BNB
//      BNB();
      
    }
    
    
    //Comunicacion Servidor
    public static void Cliente(){
       ServidorASFI servidor;  
      try {
	    LocateRegistry.createRegistry(5001); // registrar el servidor e rmi register
	    servidor= new ServidorASFI(); 
	    Naming.bind("ASFI", servidor); 
            System.out.println("El servidor esta listo Cliente\n");
        }
	catch (MalformedURLException | RemoteException | AlreadyBoundException ex) {
            System.out.println(ex);
        }
    }
    
    
    
    //Comunicacion con el Servidor BNB
    public static ArrayList<Cuenta> BNB(){
        IBNB user; 
        String Buscar;
        
        
        try {
            user = (IBNB)Naming.lookup("rmi://localhost/BNB");
            ListaBancoBNB = user.ObtenerSaldo("4657657", "Juan Perez", "Segovia");
            
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return ListaBancoBNB;
    }
    
    
     public static void BancoMercantil(){
        ServidorBancoMercantil hilo = new  ServidorBancoMercantil();
        try {
            ServidorBancoMercantil.sleep(60000);
            hilo.start();
            ConexionBancoMercantil();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServidorASFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ConexionBancoMercantil(){
           //LLamando al Servidor del BAnco Mercantil
        int port = 5001;
        String Mensaje = "Buscar:";
        Mensaje += Lista.get(0).CI+"-"+Lista.get(0).Nombres+"-"+Lista.get(0).Apellido;
        
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
            String MensajeServidor = "Mensaje del Servidor Banco Mercantil--> " + result;
            System.out.println(MensajeServidor);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void BancoBCP(){
        ServidorBancoBCP hilo1 = new  ServidorBancoBCP();
        try {
            ServidorBancoBCP.sleep(10000);
            hilo1.start();
            ConexionBancoBCP();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServidorASFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ConexionBancoBCP(){
    int puerto = 6789;
    String Ver_Fecha = "";
        try {

          //Pedimos el dato que enviaremos al servidor

            String ip="localhost";

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
            String MensajeSereci = "Mensaje del Servidor Sereci --> " + new String(respuesta.getData());
            System.out.println(MensajeSereci);
            
        }

        } catch (SocketException e) {
          System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
          System.out.println("IO: " + e.getMessage());
        }
    }
    
    
}

