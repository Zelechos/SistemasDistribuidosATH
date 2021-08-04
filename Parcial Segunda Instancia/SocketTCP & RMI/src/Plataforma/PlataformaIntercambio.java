/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Plataforma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PlataformaIntercambio extends UnicastRemoteObject implements ITransaccion {

    //Metodos de la Clase
    public PlataformaIntercambio() throws RemoteException {
        super();
    }

    @Override
    public boolean realizarTransaccion(String nrocuentacliente, String cuentavendedor, int monto, String moneda) throws RemoteException {
        int port = 5001;
        String  user = "plataforma" , pass="123";

        String MensajeServidor;
        
        try {
            Socket client = new Socket("localhost", port);

            PrintStream toServer = new PrintStream(client.getOutputStream());

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            //Aqui mandamos el mensaje al Servidor
            System.out.println("Mandando la Fecha");
            String Fecha = Fecha();
            toServer.println(Fecha);

            
            //Aqui recibimos la respuesta del Servidor
            String result = fromServer.readLine();

            //Aqui mostramos la respueta del Servidor
            MensajeServidor = "Mensaje del Servidor--> " + result;
            System.out.println(MensajeServidor);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        if(user.equals("plataforma") && pass.equals("123")){
            String token = "";
        }
        
        return true;
    }

    public static void main(String[] args) {
        PlataformaIntercambio servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new PlataformaIntercambio();
            Naming.bind("Transaccion", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
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
    
    
    public static float DolarToBolivian(int Cotizacion, int monto){
        float resp =  monto*Cotizacion;
        return resp;
    }
    
    public static float BolivianToDolar(int Cotizacion , int monto){
        float resp =  monto/Cotizacion;
        return resp;
    }

}
