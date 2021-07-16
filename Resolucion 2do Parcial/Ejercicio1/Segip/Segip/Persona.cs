namespace Segip
{
    public class Persona
    {
        public Persona() { }
        public string carnet { set; get; }
        public string nombres { set; get; }
        public string primerapellido { set; get; }
        public string segundoapellido { set; get; }
        public string fechanacimiento { set; get; }
        public string sexo { set; get; }
        public string estadocivil { set; get; }
        public Persona(string carnet, string nombres, string primerapellido, string segundoapellido, string fechanacimiento, string sexo, string estadocivil)
        {
            this.carnet = carnet;
            this.nombres = nombres;
            this.primerapellido = primerapellido;
            this.segundoapellido = segundoapellido;
            this.fechanacimiento = fechanacimiento;
            this.sexo = sexo;
            this.estadocivil = estadocivil;
        }
    }
}