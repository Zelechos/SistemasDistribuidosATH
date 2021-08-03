/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package universidad;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorSEGIP extends UnicastRemoteObject implements IVerificar {

    public static void main(String[] args) {
        ServidorUniversidad servidor;
        try {
            LocateRegistry.createRegistry(1011); // registrar el servidor e rmi register
            servidor = new ServidorUniversidad();
            Naming.bind("Segip", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);

        }
    }

    //Atributos
    //Metodos de la Clase
    public ServidorSEGIP() throws RemoteException {
        super();
    }

//    @Override
//    public Respuesta Verificar(String CI, String Nombre, String Apellidos){
//        if (CI.equals("1140506") && Nombre.equals("Walter Jhamil") && Apellidos.equals("Segovia Arellano")) {
//            return new Respuesta("Los Datos son correctos", true);
//        }
//        return new Respuesta("Los Datos del CI no son correctos", false);
//    }

    @Override
    public Respuesta Verificar(String CI, String Nombre, String Apellidos) throws RemoteException {
        if (CI.equals("1140506") && Nombre.equals("Walter Jhamil") && Apellidos.equals("Segovia Arellano")) {
            return new Respuesta("Los Datos son correctos", true);
        }
        return new Respuesta("Los Datos del CI no son correctos", false);
    }

}
