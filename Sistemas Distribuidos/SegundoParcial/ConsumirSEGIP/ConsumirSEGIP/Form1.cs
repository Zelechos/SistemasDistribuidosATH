using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsumirSEGIP
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServicioSegip.wsSEGIPSoapClient cl = new ServicioSegip.wsSEGIPSoapClient();
            ServicioSegip.Persona p = cl.ObtenerDatos(txtCarnet.Text);

            if(p != null)
            {
                txtNombres.Text = p.nombres;
                txtPrimerApellido.Text = p.primerapellido;
                txtSegundoApellido.Text = p.segundoapellido;
                txtFechaNacimiento.Text = p.fechanacimiento;
                txtEstadoCivil.Text = p.estadocivil;
                txtSexo.Text = p.sexo;
            }
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            ServicioSegip.wsSEGIPSoapClient cl = new ServicioSegip.wsSEGIPSoapClient();
            ServicioSegip.Resultado res = cl.ComprobarDatos(txtCarnet.Text , txtNombres.Text , txtPrimerApellido.Text,txtSegundoApellido.Text,txtFechaNacimiento.Text,txtSexo.Text,txtEstadoCivil.Text);

            if (res != null)
            {
                txtNombres.Text = "true";
                txtPrimerApellido.Text = "true";
                txtSegundoApellido.Text = "true";
                txtFechaNacimiento.Text = "true";
                txtEstadoCivil.Text = "true";
                txtSexo.Text = "true";
            }
        }
    }
}
