package Universidad;

class Diplomado {
    
    //Atributos de mi clase Diplomado
    private String NombreCompleto,Carrera,Fecha,Mensaje;
    
    //Constructor de Objetos Diplomado
    public Diplomado(String NombreCompleto, String Carrera,String Fecha,
            String Mensaje){
        this.NombreCompleto = NombreCompleto;
        this.Carrera = Carrera;
        this.Fecha = Fecha;
        this.Mensaje = Mensaje;
    }
    
    
    //Getters & Setters
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

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    
}
