package Code;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorAhorcado extends UnicastRemoteObject implements IAhorcado{
    
    String [] Palabras = {"Javascript","Java","HTML","CSS"};
    int Index;
    String Longitud;
    
    public ServidorAhorcado() throws RemoteException{
        super();
    }
    
    public String[] getPalabras(){
        return Palabras;
    }
    
    public void setPalabras(String[] Palabras){
        this.Palabras = Palabras;
    }
    
    @Override
    public int Iniciar(){
        Index = (int)(Math.random() * this.Palabras.length);
        Longitud = Palabras[Index];
        return Longitud.length();
    }
    
    @Override
    public int Intento(){
        
        return 0 ;
    }
    
    public static void main(String[] args) {
        
        
        
        
    }

   
    
}
