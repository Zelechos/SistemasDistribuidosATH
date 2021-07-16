using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Consumir
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void txtCarnet_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServicioSegip.wsSegipSoapClient cl = new ServicioSegip.wsSegipSoapClient();
            ServicioSegip.Persona p = cl.ObtenerDatos(txtCarnet.Text);
            if (p != null)
            {
                txtNombres.Text = p.nombres;
                txtPrimerApellido.Text = p.primerapellido;
                txtSegundoApellido.Text = p.segundoapellido;
                txtFechaNacimiento.Text = p.fechanacimiento;
                txtSexo.Text = p.sexo;
                txtEstadoCivil.Text = p.estadocivil;
                lblRespuesta.Text = "";

            }
            else {
                txtNombres.Text = null;
                txtPrimerApellido.Text = null;
                txtSegundoApellido.Text = null;
                txtFechaNacimiento.Text = null;
                txtSexo.Text = null;
                txtEstadoCivil.Text = null;
                lblRespuesta.Text = $"Error al obtener datos del usuario con Nro Carnet {txtCarnet.Text}";
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            ServicioSegip.wsSegipSoapClient cl = new ServicioSegip.wsSegipSoapClient();
            ServicioSegip.Resultado res = cl.ComprobarDatos(txtNombres.Text, txtPrimerApellido.Text, txtSegundoApellido.Text, txtFechaNacimiento.Text, txtFechaNacimiento.Text,txtSexo.Text, txtEstadoCivil.Text);

            if (res.coincidecarnet != true)
            {
                lblRespuesta.Text = "Los Datos Coinciden.";
            }
            else 
            {
                lblRespuesta.Text = "Los datos no coinciden";
            }
        }
    }
}
