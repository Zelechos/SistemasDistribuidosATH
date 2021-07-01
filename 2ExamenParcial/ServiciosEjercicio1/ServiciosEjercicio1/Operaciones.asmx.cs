using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ServiciosEjercicio1
{
    /// <summary>
    /// Descripción breve de Operaciones
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class Operaciones : System.Web.Services.WebService
    {

        [WebMethod]
        public String ObtenerDatos(int carnet, String nombres, String primerapellido, String segundoappelido, String fechanacimiento, String sexo, String estadocivil)
        {
            String res=ComprobarDatos(carnet, nombres, primerapellido, segundoappelido, fechanacimiento, sexo, estadocivil);
            

            return res;
        }

        [WebMethod]
        public string ComprobarDatos(int carnet, String nombres, String primerapellido, String segundoappelido, String fechanacimiento, String sexo, String estadocivil)
        {
           
           
        }

    }
}
