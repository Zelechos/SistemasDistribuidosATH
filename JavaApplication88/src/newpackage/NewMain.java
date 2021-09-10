/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Zelec
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String cadena = "hola como estas";
        
        String[] Separado = cadena.split("");
        
        for (int i = 0; i < Separado.length; i++) {
            System.out.println(Separado[i]);
        }
    }
    
}
