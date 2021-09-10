using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Servicios
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
        public int Suma(int a , int g)
        {
            return a+g;
        }

        [WebMethod]
        public int Resta(int a, int g)
        {
            return a - g;
        }


        [WebMethod]
        public int Multiplicacion(int a, int g)
        {
            return a * g;
        }
    }
}
