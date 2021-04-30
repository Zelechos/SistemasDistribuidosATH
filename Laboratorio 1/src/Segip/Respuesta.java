package Segip;

import java.io.Serializable;

public class Respuesta implements Serializable {
    
    //Atributos 
    boolean Estado_Respuesta;
    String Mensaje;

    //Constructor
    public Respuesta(boolean Estado_Respuesta, String Mensaje) {
        this.Estado_Respuesta = Estado_Respuesta;
        this.Mensaje = Mensaje;
    }

    //Getters & Setters
    public boolean getEstado_Respuesta() {
        return Estado_Respuesta;
    }

    public void setEstado_Respuesta(boolean Estado_Respuesta) {
        this.Estado_Respuesta = Estado_Respuesta;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    
}
