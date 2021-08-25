/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio2;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements IGenerador {

    //Atributos
    private String Cadena = "";

    //Metodos de la Clase
    public Servidor() throws RemoteException {
        super();
    }

    //
    @Override
    public boolean introducirvalor(String cadena) throws RemoteException {
        Cadena += cadena;
        return true;
    }

    @Override
    public String duplicar() throws RemoteException {
        Cadena += Cadena;
        return Cadena;
    }

    @Override
    public String aumentarespacios(int Number) throws RemoteException {

        String respuesta = AumentandoEspacios(Number, Separar(Cadena));
        Cadena = "";
        Cadena += respuesta;
        return respuesta;
    }

    @Override
    public String mayuscula(String cadena) throws RemoteException {

        String response = ConvirtiendoMayusculas(Separar(Cadena));
        return response + cadena;
    }

    public static void main(String[] args) {
        Servidor servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new Servidor();
            Naming.bind("Operaciones", servidor);
            System.out.println("El servidor esta listo\n");
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
                if (!letras[i].equals("|")) {
                    letras[i] += "|";
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

}
