package Programador;

public class Stack {
    
    private int Codigo;
    private String Especialidad;

    public Stack(int Codigo, String Especialidad) {
        this.Codigo = Codigo;
        this.Especialidad = Especialidad;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
    
}
