package SistemaDeEmision;

import java.io.Serializable;

public class Cuenta implements Serializable {
    
    private String Numero_Cuenta;
    private String CI;
    private String Nombre , Apellidos;
    private double Saldo;
    private Banco banco;
    
    //Constructor
    public void Cuenta( String Numero_Cuenta , String CI, String Nombre , String Apellidos , double Saldo , Banco banco){
        this.Numero_Cuenta = Numero_Cuenta;
        this.CI = CI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Saldo = Saldo;
        this.banco = banco;
    }
    
//Metodos Getters & Setters
    public String getNumero_Cuenta() {
        return Numero_Cuenta;
    }

    public void setNumero_Cuenta(String Numero_Cuenta) {
        this.Numero_Cuenta = Numero_Cuenta;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    
    
}
