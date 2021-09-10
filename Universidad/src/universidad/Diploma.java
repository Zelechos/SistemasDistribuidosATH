package universidad;

import java.io.Serializable;

public class Diploma implements Serializable{
    
    String NombreCompleto;
    String Carrera;
    String Mensaje;
    String Fecha;

    public Diploma(String NombreCompleto, String Carrera, String Mensaje, String Fecha) {
        this.NombreCompleto = NombreCompleto;
        this.Carrera = Carrera;
        this.Mensaje = Mensaje;
        this.Fecha = Fecha;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
    
    
}
