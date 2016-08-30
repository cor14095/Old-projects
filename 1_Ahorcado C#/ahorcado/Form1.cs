using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        string[] pal = new String[] { "hipopotomonstrosesquipedaliofobia", "brega", "hola", "arroz", "visicitud", "palindromo", "dingolondango", "cogitabundo", "carpetovetonico", "emascular", "abigarrar", "deyeccion", "adlatere", "filosofastro", "albricias", "oximoros", "forunculo", "chirimbolo", "esperpento", "pendenciero", "brega" }; //Vector de palabras
        int num;
        int c = 0;
        int c2 = 0;

        private int Rndm(int min, int max)
        {
            Random random = new Random();
            return random.Next(min, max);
        }

        private void check(string s, ref int cont)
        {

            for (int i = 0; i < pal[num].Length; i++)
            {
                if (s[0] == pal[num][i])
                {
                    textBox1.Text = textBox1.Text.Remove(i, 1);
                    textBox1.Text = textBox1.Text.Insert(i, s);
                }
            }
            if (pal[num].IndexOf(s) == -1) { cont++; };
        }

        private void perdio()
        {
            button1.Enabled = true;
            button2.Enabled = false;
            button3.Enabled = false;
            button4.Enabled = false;
            button5.Enabled = false;
            button6.Enabled = false;
            button7.Enabled = false;
            button8.Enabled = false;
            button9.Enabled = false;
            button10.Enabled = false;
            button11.Enabled = false;
            button12.Enabled = false;
            button13.Enabled = false;
            button14.Enabled = false;
            button15.Enabled = false;
            button16.Enabled = false;
            button17.Enabled = false;
            button18.Enabled = false;
            button19.Enabled = false;
            button20.Enabled = false;
            button21.Enabled = false;
            button22.Enabled = false;
            button23.Enabled = false;
            button24.Enabled = false;
            button25.Enabled = false;
            button26.Enabled = false;
            button27.Enabled = false;
            button28.Enabled = false;

            c = 0;
            textBox1.Text = pal[num];

        }

        private void refrescar()
        {
            button2.Enabled = true;
            button3.Enabled = true;
            button4.Enabled = true;
            button5.Enabled = true;
            button6.Enabled = true;
            button7.Enabled = true;
            button8.Enabled = true;
            button9.Enabled = true;
            button10.Enabled = true;
            button11.Enabled = true;
            button12.Enabled = true;
            button13.Enabled = true;
            button14.Enabled = true;
            button15.Enabled = true;
            button16.Enabled = true;
            button17.Enabled = true;
            button18.Enabled = true;
            button19.Enabled = true;
            button20.Enabled = true;
            button21.Enabled = true;
            button22.Enabled = true;
            button23.Enabled = true;
            button24.Enabled = true;
            button25.Enabled = true;
            button26.Enabled = true;
            button27.Enabled = true;
            button28.Enabled = true;
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            perdio();
            textBox1.Text = "La palabra sera mostrada aqui";
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            Graphics canvas = pictureBox1.CreateGraphics();
            Pen brown = new Pen(Color.SaddleBrown);
            Pen blanco = new Pen(Color.White);

            refrescar();
            canvas.Clear(Color.White);

            brown.Width = 10;
            
            canvas.DrawLine(brown, 30, 290, 120, 290);
            canvas.DrawLine(brown, 75, 290, 75, 20);
            canvas.DrawLine(brown, 75, 155, 237, 20);
            canvas.DrawLine(brown, 75, 20, 400, 20);
            canvas.DrawLine(brown, 380, 20, 380, 80);

            num = Rndm(0, 20);

            textBox1.Text = "";
            listBox1.Items.Clear();
            listBox1.Items.Add("Las letras que a utilizado son:");
            c2 = 1;

            int largo = pal[num].Length;
            for (int i = 0; i < largo; i++) {
                textBox1.Text += '_';
            };

            button1.Enabled = false;

        }

        private void button3_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Button but;
            but = sender as Button;

            check(but.Text.ToLower(), ref c);
            listBox1.Items.Add(c2.ToString()+"_ "+but.Text);
            c2++;

            Graphics canvas = pictureBox1.CreateGraphics();
            Pen piel = new Pen(Color.SandyBrown);
            Pen negro = new Pen(Color.Black);
            piel.Width = 3;

            switch (c) {
                case 1: canvas.DrawEllipse(piel, 360, 80, 40, 40);
                    break;
                case 2: canvas.DrawLine(piel, 380, 120, 380, 200);
                    break;
                case 3: canvas.DrawLine(piel, 340, 170, 380, 140);
                    break;
                case 4: canvas.DrawLine(piel, 420, 170, 380, 140);
                    break;
                case 5: canvas.DrawLine(piel, 340, 240, 380, 200);
                    break;
                case 6: canvas.DrawLine(piel, 420, 240, 380, 200);
                    canvas.DrawLine(negro, 370, 90, 390, 100);
                    canvas.DrawLine(negro, 390, 90, 370, 100);
                    canvas.DrawLine(negro, 370, 110, 390, 110);
                    break;
            }

            if (c < 6 && textBox1.Text == pal[num])
            {
                MessageBox.Show("GANO!!! :D");
                perdio();
            } if (c == 6) { perdio(); MessageBox.Show("PERDIO!!! D:"); }

            but.Enabled = false;
        }
    }
}
