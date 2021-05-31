/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package Ejercicio1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        
        int port = 5001, Number; 
        String  Proceso1[], salir = "Respuesta" , mensaje="",send="";
        boolean estado = false;
        int Proceso2[];
       do{
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            Socket client;
            PrintStream toClient;       
         
            client = server.accept(); //conexion
            
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            toClient = new PrintStream(client.getOutputStream()); 
            
            String fast = fromClient.readLine();

            Proceso1 = ProcesoIncial(fast);
            Proceso2 = ProcesoFinal(Proceso1);
            
            //Transformamos el String a un numero Entero
            if(estado==false){
                
                send = fast.concat(" OK");
                toClient.println(send);
                mensaje = fromClient.readLine();
                estado = true;
            }
            
            if(salir.equals(mensaje) && estado){
                toClient.println(Mayor(Proceso2));
            }
            
            //Instanciamos el Metodo Estatico Factorial y mostramos el resultado de la del Factorial
            System.out.println("Mandando respuesta al Cliente . . .");
            System.out.println("Fin de la Conexion");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        }while(salir.equals(mensaje));
  
    }
    
    //Metodo que transforma de String a Entero
    public static int TextToNumber (String texto){
        int Number =  Integer.parseInt(texto);
        return Number;
    }
    
    public static String[] ProcesoIncial(String Texto){
        String Separado[];
        Separado = Texto.split(",");
        return Separado;
    }
    
    public static int[] ProcesoFinal(String[] Texto){
        int Separado[] = new int[3];
        String Tupla[];
        for(int i = 0; i < Texto.length; i++) {
            Tupla = Texto[i].split("-");        
            Separado[i] = Integer.parseInt(Tupla[0].trim());
        }
        return Separado;
    }
    
    public static int Mayor(int Numbers[]){
        int Mayor;
        
        Mayor = Numbers[0];
       
        for(int i = 0; i < Numbers.length; i++) {
            
            if(Numbers[i] > Mayor) {
                Mayor = Numbers[i];
            }
            
        }
        return Mayor;
    }
        
    public static String CrearMensaje(int numbers[]){
        String Text = "";
        for (int i = 0; i < numbers.length; i++) {
            Text += "-"+numbers[i];
        }
        return Text.concat("-OK");
    }
    
     //Metodo que Genera el Factorial
    public static int Factorial(int Number){
        if(Number == 0 || Number == 1){
            return 1;
        }
        return Number * Factorial(Number-1);
    }
    
}
