/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteoperacionesjava;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ClienteOperacionesJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a =4 , m =3;
        System.out.println(suma(a, m));
    }

    private static int suma(int a, int g) {
        clienteoperacionesjava.Operaciones service = new clienteoperacionesjava.Operaciones();
        clienteoperacionesjava.OperacionesSoap port = service.getOperacionesSoap();
        return port.suma(a, g);
    }
    
}
