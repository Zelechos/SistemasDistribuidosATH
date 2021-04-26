/*
 * @Author : Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/SistemasDistribuidosATH
 */
package AhorcadoRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class ServidorAhorcado extends UnicastRemoteObject implements IAhorcado {

    //Atributos
    String Palabras[] ={"java","javascript","html","css","nodejs","express","python","reactjs","angularjs","golang","docker"};
    String Palabra , PalabraHallada[], PalabraEscogida[],PalabraFinal[];
    
    //Metodos de la Clase
    public ServidorAhorcado() throws RemoteException {
        super();
    }
    
    @Override
    public String Iniciar() throws RemoteException {
        return Palabra;
    }
    
    @Override
    public String Mensaje() throws RemoteException {
        this.Palabra = Sorteo(Palabras);
        return MuestraVacios(this.Palabra);   
    }
    
    
    //Realiza el Sorteo de las Palabras
    @Override
    public String Sorteo(String Palabras[]){
        int Index = (int) Math.floor(Math.random() * Palabras.length);
        return Palabras[Index];
    }
    
    //Muestra una la cantidad de letras de la palabra seleccionada 
    @Override
    public String MuestraVacios(String Palabras) throws RemoteException {
        int longitud = Palabras.length();
        this.PalabraHallada = new String[longitud];

        
        String Texto = "";
            for(int Iterador = 0 ; Iterador < longitud ; Iterador++){
                if(Iterador == longitud-1){
                    this.PalabraHallada[Iterador] = "?";
                    Texto += "[?]";
                }else{
                    this.PalabraHallada[Iterador] = "?";
                    Texto += "[?]-";
                }
            }
        return Texto;
    }
    
    
    @Override
    public String Jugando(String Letra) throws RemoteException{
        this.PalabraEscogida = this.Palabra.split(""); 
        
        boolean intento = false;
        
        String men1,men2,let=Letra.trim();

        
        
        //Bucle for para saber en que si la letra esta en diferentes indices
        for (int Interador = 0; Interador < this.PalabraEscogida.length; Interador++) {
            
            //if para generar un array con los indices que donde se encuentra la letra introducida
            if(let.equals(this.PalabraEscogida[Interador])){
                if(this.PalabraHallada[Interador].equals("?")){
                    this.PalabraHallada[Interador] =  this.PalabraEscogida[Interador];
                    intento = true;
                }
            }
            
        }
        
        
        if(intento){
            men2 = "Se encontro concidencias";
            intento = false;
            return men2;
        }else{
            men1  = "Menos 1 Intento.";
            return men1;
        }
        
        
    }

    @Override
    public String Intento() throws RemoteException {
        //para crear un array con la letra introducida
        String Texto = "";
            for(int Iterador = 0 ; Iterador < this.PalabraHallada.length ; Iterador++){
                if(Iterador == this.PalabraHallada.length-1){
                    Texto += "["+this.PalabraHallada[Iterador]+"]";
                }else{
                    Texto += "["+this.PalabraHallada[Iterador]+"]-";
                }
            }
        return Texto;
    }
    
    
    @Override
    public String Victoria()throws RemoteException{
        if(Arrays.equals(this.PalabraEscogida, this.PalabraHallada)){
            return "Felicidades Ganaste";
        }else{
            return "Apunto de Morir";
        }
    }
    

       
  public static void main(String[] args) {
       ServidorAhorcado servidor;  
      try {
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
	    servidor=new ServidorAhorcado(); 
	    Naming.bind("Ahorcado", servidor); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }



  
   
}
