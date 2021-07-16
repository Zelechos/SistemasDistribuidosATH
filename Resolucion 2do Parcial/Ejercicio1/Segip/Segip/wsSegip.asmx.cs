using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Segip
{
    /// <summary>
    /// Descripción breve de wsSegip
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class wsSegip : System.Web.Services.WebService
    {

        [WebMethod]
        public Persona ObtenerDatos(String CI)
        {
            Persona aux = null;
            if (CI == "1234567")
            {
                aux = new Persona("1234567", "juan", "perez", "perez", "15-02-1995", "M", "C") ;
            }
            return aux;
        }

        [WebMethod]
        public Resultado ComprobarDatos(String carnet , String nombres , String primerapellido, String segundoapellido, String fechanacimiento, String sexo, String estadocivil)
        {
            Resultado res = new Resultado();
            Persona aux = new Persona("1234567", "juan", "perez", "perez", "15-02-1995", "M", "C");

            res.coincidecarnet = carnet == aux.carnet;
            res.coincidenombres = nombres == aux.nombres;
            res.coincideprimerapellido = primerapellido == aux.primerapellido;
            res.coincideprimerapellido = segundoapellido == aux.segundoapellido;
            res.coincidefechanacimiento = fechanacimiento == aux.fechanacimiento;
            res.coincidesexo = sexo == aux.sexo;
            res.coincideestadocivil = estadocivil == aux.estadocivil;
            
            return res;
        }
    }
}
