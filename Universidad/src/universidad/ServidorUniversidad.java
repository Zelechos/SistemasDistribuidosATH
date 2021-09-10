/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package universidad;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorUniversidad extends UnicastRemoteObject implements IUniversidad {

    public static void main(String[] args) {
        ServidorUniversidad servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorUniversidad();
            Naming.bind("Universidad", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }

    }

    //Atributos
    //Metodos de la Clase
    public ServidorUniversidad() throws RemoteException {
        super();
    }

    @Override
    public Diploma EmitirDiploma(String CI,
            String Nombre,
            String PrimerApellido,
            String SegundoApellido,
            String FechaNacimiento,
            String Carrera) throws RemoteException {

        String NombreCompleto = Nombre + PrimerApellido + SegundoApellido;
        String ApellidoCompleto = PrimerApellido.trim() + " " + SegundoApellido.trim();

        String Mensaje = "";

        //Respuesta del servidor
        //Importamos nuestro RMI para el uso de sus Metodos
        IVerificar segip;
        try {

            segip = (IVerificar) Naming.lookup("rmi://localhost/Segip");

            Respuesta respuesta = segip.Verificar(CI, Nombre, ApellidoCompleto);

            if (!respuesta.getEstadoRespuesta()) {
                Mensaje += respuesta.getMensaje();
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Diploma(NombreCompleto, Carrera, Mensaje, FechaNacimiento);

    }

}
