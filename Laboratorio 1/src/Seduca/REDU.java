package Seduca;

public class REDU {

    public static void main(String[] args) {
        String ether = "Walter jahmil";
        String ether1 = "Segovia";
        String ether2 = "Arellano";
        String fech = "11-02-1996";

        System.out.println(extraerPrimerosDosCaracteres(ether)+
                extraerPrimerosDosCaracteres(ether1)+
                extraerPrimerosDosCaracteres(ether2)+
                fecha(fech));   
    }
    
    
    public static String extraerPrimerosDosCaracteres(String Palabra) {
        if (Palabra.length() < 2) {
            return Palabra.substring(0) + " ";
        }
        return Palabra.substring(0, 2);
    }
    
    public static String fecha(String fecha){
        return fecha.replace("-", "");
    }
    
    
}
