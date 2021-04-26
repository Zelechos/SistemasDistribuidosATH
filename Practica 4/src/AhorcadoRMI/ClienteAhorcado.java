/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package AhorcadoRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteAhorcado {

    public static void main(String[] args) {
        IAhorcado juego;
        Scanner Input = new Scanner(System.in);
        int intentos = 5 ;
        String letra ,p,is;
        //LLenamos los arrays A & B
        
        try {
            //Respuesta del servidor
            juego = (IAhorcado)Naming.lookup("rmi://localhost/Ahorcado");
            
            //Empezamos con el Juego 
            System.out.println("[---Bienvenido al Juego de el Ahorcado---]\n Tienes 5 Intentos para adivinar la palabra: ");
            String mensaje = juego.Mensaje();
            System.out.println(mensaje);
            do{
                System.out.print("Escriba una Letra : ");
                letra = Input.nextLine();
                p = juego.Jugando(letra);
                is = juego.Intento();
                if(p.equals("Menos 1 Intento.")){
                    intentos--;
                }
                System.out.println(p);
                System.out.println(is);
                System.out.println("Numero de Oportunidades : "+intentos);
                if(juego.Victoria().equals("Felicidades Ganaste")){
                    System.out.println(juego.Victoria());
                    System.out.println("Adivinaste la Palabra era == > "+juego.Iniciar());
                    System.exit(0);
                }

            }while(intentos != 0 );
            System.out.println("PERDISTE!!!");
          
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
    
}
