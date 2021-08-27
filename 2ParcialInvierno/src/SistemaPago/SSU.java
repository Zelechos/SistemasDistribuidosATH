/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package SistemaPago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class SSU extends UnicastRemoteObject implements IAfiliacion {

    //Atributos
    private static String Cadena = "";
    private static String CI = "";

    //Metodos de la Clase
    public SSU() throws RemoteException {
        super();
    }
    
    @Override
    public String SolicitarAfiliacion(String ci, String nombres, String apellidos, String fechanacimiento) throws RemoteException {
        CI += ci;
        
        //Socket TCP CLIENTE USFX
        //----------------------------------------------------------------
        int puerto = 5001;
        String Mensaje = "";

        try {
            Socket client = new Socket("localhost", puerto);

            PrintStream toServer = new PrintStream(client.getOutputStream());

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            //Aqui mandamos el mensaje al Servidor
            String data = CI;
            toServer.println(data);
            
            System.out.println("Enviando la data al servidor usfx-->"+data);

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
        
        Cadena += "no se puede continuar con su al filiación porque está afiliado a la caja";
        return Cadena;
    }

    public static void main(String[] args) {
        SSU servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new SSU();
            Naming.bind("SSU", servidor);
            System.out.println("El servidor SSU esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
        }
        
        
         
        
    }

    //Metodo que transforma de String a Entero
    public static String[] Separar(String cadena) {
        String[] Separado = cadena.split("");
        return Separado;
    }

    public static String AumentandoEspacios(int numero, String[] letras) {
        String texto = "";
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < numero; j++) {
                if (!letras[i].equals(" ")) {
                    letras[i] += " ";
                }
            }
            texto += letras[i];
        }
        return texto;
    }

    public static String ConvirtiendoMayusculas(String[] letras) {
        String texto = "";
        for (int i = 0; i < letras.length; i++) {
            texto += letras[i].toUpperCase();
        }
        return texto;
    }
    
    @Override
    public String Show(){
        return Cadena;
    }

    

}
