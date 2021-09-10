using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Segip
{
    /// <summary>
    /// Descripción breve de wsSEGIP
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class wsSEGIP : System.Web.Services.WebService
    {

        [WebMethod]
        public Persona ObtenerDatos(String CI)
        {
            Persona aux = null;
            if (CI == "1234567") 
            {
                aux = new Persona("1234567","juan","perez","perez","15-06-1996","M","C");
            }
            return aux;
        }


        [WebMethod]
        public Resultado ComprobarDatos(String carnet, String nombres, String primerapellido, String segundoapellido, String fechanacimiento, String sexo , String estadocivil)
        {
            Resultado rest = new Resultado();
            Persona aux = new Persona("1234567", "juan", "perez", "perez", "15-06-1996", "M", "C") ;

            rest.coincidecarnet = carnet == aux.carnet;
            rest.coincideestadocivil = estadocivil == aux.estadocivil;
            rest.coincidefechanacimiento = fechanacimiento == aux.fechanacimiento;
            rest.coincidenombres = nombres == aux.nombres;
            rest.coincideprimerapellido = primerapellido == aux.primerapellido;
            rest.coincidesegundoapellido = segundoapellido == aux.segundoapellido;
            rest.coincidesexo = sexo == aux.sexo;

            return rest;
        }
    }
}
