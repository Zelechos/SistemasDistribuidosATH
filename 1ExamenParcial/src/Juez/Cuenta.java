package Juez;

public class Cuenta {

    
    enum Banco{
        BNB,
        BancoMercantil,
        BancoBCP
    }
    
    String NroCuenta;
    String CI;
    String Nombres; 
    String Apellido;
    double Saldo;

    public Cuenta(String NroCuenta, String CI, String Nombres, String Apellido, double Saldo) {
        this.NroCuenta = NroCuenta;
        this.CI = CI;
        this.Nombres = Nombres;
        this.Apellido = Apellido;
        this.Saldo = Saldo;
    }

    public Banco getBNB(){
        return Banco.BNB;
    }
    
    public Banco getBancoMercantil(){
        return Banco.BancoMercantil;
    }
    
    public Banco getBCP(){
        return Banco.BancoBCP;
    }
    
    public String getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(String NroCuenta) {
        this.NroCuenta = NroCuenta;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    
    
    
    
    
    
    
}
