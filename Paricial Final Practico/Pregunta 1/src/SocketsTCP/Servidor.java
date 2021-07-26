/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package SocketsTCP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    public static void main(String[] args) {
        
        int port = 5001, Valor; 
        
        String Mensaje , Comando;
        ArrayList ListadeCadenasCopia = new ArrayList();
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            
            
            
            do{

            Socket client;
            PrintStream toClient;       
            client = server.accept(); //conexion

            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            
            //Transformamos el String a un numero Entero
            Mensaje = fromClient.readLine();
            Comando = ReturnComand(Mensaje);

                    
            toClient = new PrintStream(client.getOutputStream()); 

            if(Comando.equals("introducir")){
                toClient.println(Introducir(Mensaje));
            }
                
                
            if(Comando.equals("cadena")){
                ListadeCadenasCopia = CopiaCadena(Mensaje);
                toClient.println(Cadena(Mensaje));
            }
                
            if(Comando.equals("factorial")){
                String s = ReturnFactorial(Mensaje);
                toClient.println(s);
            }
                
                if(Comando.equals("fibonaci")){ 
                    toClient.println(ReturnFibonacci(Mensaje));
                }
                
                if(Comando.equals("invertir")){ 
                    toClient.println(Invertir(ListadeCadenasCopia));
                }
                
                if(Comando.equals("oracion")){ 
                    toClient.println(Oracion(Mensaje, ListadeCadenasCopia));
                }
            
            System.out.println("Mandando respuesta al Cliente . . .");
            
            }while(Mensaje.equals("FIN"));
            System.out.println("Fin de la Conexion");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
  
    }
    
    
    //Metodo para Introducir
    
    public static String Introducir(String Mensaje){
        List ListaNumeros = new ArrayList();
        int Valor = ReturnValue(Mensaje);
        ListaNumeros.add(Valor);
        return "exito : "+ true;
    }
    
    public static String Invertir(ArrayList Cadena){
        int longitud = Cadena.size();
        if(longitud == 0){
            return "resultado : no_n";
        }else{
            return "resultado : "+ Cadena.get(1);
        }
    }
    
    public static String Cadena(String Mensaje){
        List ListaCadenas = new ArrayList();

        String Cadena = ReturnCadena(Mensaje);
        ListaCadenas.add(Cadena);
        return "exito : "+ true;
    }
    
    public static ArrayList CopiaCadena(String Mensaje){
        ArrayList ListaCadenas = new ArrayList();

        String Cadena = ReturnCadena(Mensaje);
        ListaCadenas.add(Cadena);
        return ListaCadenas;
    }
    
    public static String ReturnFactorial(String Mensaje){
        int Valor = ReturnValue(Mensaje);
        int factorial = Factorial(Valor);
        String respuesta = NumberToText(factorial);
        if(Valor > -1){
            return "resultado : "+ respuesta;
        }else{
            return "resultado : no_n";
        }
    }
    
    
    public static String ReturnFibonacci(String Mensaje){
        int Valor = ReturnValue(Mensaje);
        String respuesta = Fibonacci(Valor);
        if(Valor > 0){
            return "resultado : "+ respuesta;
        }else{
            return "resultado : no_n";
        }
    }
    
    
    public static String Oracion(String Mensaje, ArrayList Cadena){
        
        int longitud = Cadena.size();
        if(longitud == 0){
            return "resultado : no_n";
        }else{
            return "resultado : "+  upperCaseFirst(ReturnCadena(Mensaje));
        }
    }
    
    public static String upperCaseFirst(String val) {
      char[] arr = val.toCharArray();
      arr[0] = Character.toUpperCase(arr[0]);
      return new String(arr);
   }
    
    
    //Metodo que transforma de String a Entero
    public static int TextToNumber (String texto){
        int Number =  Integer.parseInt(texto);
        return Number;
    }
    
    //Metodo que transforma de String a Entero
    public static String NumberToText (int numero){
        String Texto =  String.valueOf(numero);
        return Texto;
    }
    
    
    //Metodo para Recuperar el comando 
    public static String ReturnComand(String comando){
        String[] Separado = comando.split("\\:");
        return Separado[0].trim();
    }
    
    //Metodo para Recuperar el valor 
    public static int ReturnValue(String valor){
        String[] Separado = valor.split("\\:");
        int numero = TextToNumber(Separado[1].trim());
        return numero;
    }
    
    //Metodo para Recuperar el valor 
    public static String ReturnCadena(String cadena){
        String[] Separado = cadena.split("\\:");
        return Separado[1].trim();
    }
    
    
     //Metodo que Genera el Factorial
    public static int Factorial(int Number){
        if(Number == 0 || Number == 1){
            return 1;
        }
        return Number * Factorial(Number-1);
    }
    
    
    //Metodo que Genera la serie Fibonacci
    public static String Fibonacci(int Number){
        
        int f = 0 , t1 = 1, t2;
        String Sucesion =" ";
        for (int i = 1; i < Number; i++) {
            t2 = f;
            f = t1 + f;
            t1=t2;
            Sucesion += NumberToText(t1) + " , ";
        }
        
        
        return Sucesion;
    }
    
}
