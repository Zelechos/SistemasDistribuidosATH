package universidad;

import java.io.Serializable;

public class Respuesta implements Serializable{
    
    boolean EstadoRespuesta;
    String Mensaje;

    public Respuesta(String Mensaje, boolean EstadoRespuesta) {
        this.Mensaje = Mensaje;
        this.EstadoRespuesta = EstadoRespuesta;
}

    public boolean getEstadoRespuesta() {
        return EstadoRespuesta;
    }

    public void setEstadoRespuesta(boolean EstadoRespuesta) {
        this.EstadoRespuesta = EstadoRespuesta;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
}
