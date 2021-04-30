package Universidad;

import Segip.VerificacionDeDatos;
import Segip.Respuesta;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServidorUniversidadRMI extends UnicastRemoteObject implements EmitirDiplomas{
    
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
        
    }

    //Metodo para obetener la Fecha del Sistema
    public static String Fecha(){
        Calendar Fechas = new GregorianCalendar();
        int Year, Month, Day;
        String Fecha_Actual;
        
        Year = Fechas.get(Calendar.YEAR);
        Month = Fechas.get(Calendar.MONTH);
        Day = Fechas.get(Calendar.DAY_OF_MONTH);
        
        //Generamos la Fecha Actual
        Fecha_Actual = String.format(" %d/%d/%d ", Day, Month + 1, Year);
        
        return Fecha_Actual;
    }
    
    //Metodo para generar el Apellido Completo
    public static String Apellidos(String ApellidoPaterno, String ApellidoMaterno){
        String Apellido = String.format("%s %s", ApellidoPaterno ,ApellidoMaterno);
        return Apellido;
    }
    
    //Metodo para generar el Nombre Completo
    public static String NombreCompleto(String Nombre, String Apellidos){
        String Nombre_Completo = String.format(" %s %s", Nombre , Apellidos);
        return Nombre_Completo;    
    }
    
    
    @Override
    public Diplomado EmitirDiploma(String CI,
            String Nombre,
            String Apellido_Paterno,
            String Apellido_Materno,
            String Carrera,
            String Fecha_Nacimiento) throws RemoteException {
        
        VerificacionDeDatos Segip;
        String Apellido_Completo =  Apellidos(Apellido_Paterno, Apellido_Materno);
        String Mensaje = "";
      

        
        //LLamando al Servidor del Segip
         try {
            Segip = (VerificacionDeDatos) Naming.lookup("rmi://localhost/ServerSegip");
            Respuesta Respuesta_Segip = Segip.VerificarDatos(CI, Nombre, Apellido_Completo);
            
            
            if (!Respuesta_Segip.getEstado_Respuesta()) {
                Mensaje += Respuesta_Segip.getMensaje();
            }
            
            //Generamos la fecha actual del sistema 
            String Fecha = Fecha();
        
            // Generamos el String NombreCompleto
            String Nombre_Completo = NombreCompleto(Nombre, Apellido_Completo);
            //Instancia del Diplomado
            return new Diplomado(Nombre_Completo, Carrera, Fecha, Mensaje);
            

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
}
