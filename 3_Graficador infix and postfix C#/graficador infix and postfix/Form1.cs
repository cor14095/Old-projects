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
        TPostfix f = new TPostfix();
        double paso, lix = 0, lsx = 0, liy = 0, lsy = 0, x1 = 0, y1 = 0;

        public partial class TPostfix
        {
            public double[] num = new double[99];
            public string post = "";
            public bool error = false;
            
            public Stack<char> data = new Stack<char>();
            Stack<double> evl = new Stack<double>();

            public void MyVal(string a, ref double a1, ref int a2) 
            {

                int b, c, d, e, cont1 = 1, cont2 = 0;
                string s1 = a;
                while (cont1 < s1.Length)
                {
                    b = (int)s1[cont1];
                    c = (int)'0';
                    d = b - c;
                    if ("0123456789".IndexOf(d.ToString()) != -1)
                    {
                        a2 = 0;
                        cont1++;
                        if (d == -2) 
                        { 
                            cont2 += 1; e = s1.IndexOf(s1[cont2]); if (cont2 > 1) 
                            { 
                                MessageBox.Show("Ingreso dos puntos"); 
                                a2 = s1.IndexOf(s1[cont2]); 
                                cont1 = s1.Length + 1; 
                            } 
                       }
                    }
                    else 
                    { 
                        a1 = Convert.ToDouble(s1.Substring(0, cont1));
                        a2 = s1.IndexOf(s1[cont1]);
                        cont1 = s1.Length + 1;
                    }
                }
                if (a2 == 0) { a1 = Convert.ToDouble(a); }
            }

            private int jer(char c)
            {
                return ("(+-*/^R~SCTLE".IndexOf(c)) / 2;
            }

            private void signo(char c)
            {
                while ((data.Count != 0) && (jer(c) <= jer(data.Peek())))
                {
                    post += data.Pop();
                }
                data.Push(c);
            }

            public void create(string s)
            {
                int i = 0, cont = 0;
                double n = 0;
                Boolean ts = false;
                string t = "";
                s = s.ToLower();
                post = "";

                while (i < s.Length)
                {

                    if (s[i] == '(') { data.Push(s[i++]); } else 
                    
                    if (s[i] == ')') 
                    {
                        while ((data.Count != 0) && (data.Peek() != '(' )) 
                        {
                            post += data.Pop();
                        }
                        data.Pop(); i++; //ts = true;
                    } else

                    if ("xyz".IndexOf(s[i]) != -1)
                    {
                        if (ts) { signo('*'); }
                        post += s[i++];
                        ts = true;
                    } else

                    if ("0123456789".IndexOf(s[i]) != -1)
                    {
                        t = s.Substring(i, s.Length - i);
                        MyVal(t, ref n, ref cont);
                        if (cont != 0)
                        {
                            t = t.Substring(0, cont);
                            i += cont;
                        }
                        else { i += s.Length + 1; }
                        post += '#';
                        num[post.Length-1] = n;
                        ts = true;
                        cont = 0;
                    } else

                    if ("+-*/^~".IndexOf(s[i]) != -1) 
                    {
                        if (ts)
                        {
                            signo(s[i]);
                        }
                        else
                        {
                            if (s[i] == '-')
                            {
                                signo('~');
                            }
                            else { MessageBox.Show("Error de sintaxis en el " + i.ToString() + " espacio."); }
                        }
                        ts = false; i++;
                    } else

                    if ("rsctle".IndexOf(s[i]) != -1)
                    {
                        data.Push(s[i++]);
                    } else

                        if (s[i] == ' ') { i++; } else { MessageBox.Show("Error de sintaxys"); error = true; i++; }
                }

                if (error)
                {
                    post = "#";
                    num[0] = 0;
                }
                else
                {
                    while (data.Count != 0) { post += data.Pop(); }
                }

            }

            public double eval(double x, double y, double z)
            {

                if (error) { MessageBox.Show("Error en el Postfix"); return 0; }
                else
                {
                    for (int i = 0; i < post.Length; i++)
                    {
                        switch (post[i])
                        {
                            case '#': evl.Push(num[i]); break;
                            case 'x': evl.Push(x); break;
                            case 'y': evl.Push(y); break;
                            case 'z': evl.Push(z); break;
                            case '+': evl.Push(evl.Pop()+evl.Pop()); break;
                            case '~': evl.Push(-evl.Pop()); break;
                            case '-': evl.Push(-evl.Pop() + evl.Pop()); break;
                            case '*': evl.Push(evl.Pop() * evl.Pop()); break;
                            case '/': if (evl.Peek() == 0) { MessageBox.Show("Div by cero"); } else { double t1 = evl.Pop(); double t2 = evl.Pop(); evl.Push(t2 / t1); } break;
                            case '^': double t3 = evl.Pop(); double t4 = evl.Pop(); evl.Push(Math.Pow(t4, t3)); break;
                            case 's': evl.Push(Math.Sin(evl.Pop())); break;
                            case 'c': evl.Push(Math.Cos(evl.Pop())); break;
                            case 't': evl.Push(Math.Tan(evl.Pop())); break;
                            case 'l': evl.Push(Math.Log10(evl.Pop())); break;
                            case 'e': evl.Push(Math.Exp(evl.Pop())); break;
                            case 'r': evl.Push(Math.Sqrt(evl.Pop())); break;
                        }
                    }
                    if (evl.Count == 1)
                    {
                        return evl.Peek();
                    }
                    else { return evl.ElementAt(1); }
                }
            }
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text != "")
            {
                f.create(textBox1.Text);
                double xr = double.Parse(textBox6.Text);
                textBox7.Text = (f.eval( xr, 0, 0)).ToString();
            }
        }

        public int xp(double x, double w, double lii, double lis)
        {
            return Convert.ToInt32(Math.Truncate(((x - lii) * w) / (lis - lii)));
        }
        public int yp(double y, double h, double lii, double lis)
        {
            return Convert.ToInt32(Math.Truncate(((lis - y) * h) / (lis - lii)));
        }

        private void button2_Click(object sender, EventArgs e)
        {
            f.create(textBox1.Text);

            lsx = Convert.ToInt32(textBox2.Text);
            lix = Convert.ToInt32(textBox3.Text);

            paso = (lsx - lix) / 100;
            x1 = lix; y1 = f.eval(x1, 0, 0);

            if (checkBox1.Checked != true)
            {
                liy = y1; lsy = y1;
                while (x1 <= lsx)
                {
                    x1 = x1 + paso;
                    y1 = f.eval(x1, 0, 0);
                    if (y1 < liy) { liy = y1; }
                    if (y1 > liy) { lsy = y1; }
                }
            }
            else
            {
                lsy = Convert.ToInt32(textBox4.Text);
                liy = Convert.ToInt32(textBox5.Text);
            }

            x1 = lix; y1 = f.eval(x1, 0, 0);
            Graphics img1 = null;
            Pen black = new Pen(Color.Black); black.Width = 1;
            Pen red = new Pen(Color.Red); red.Width = 3;

            img1 = pictureBox1.CreateGraphics();
            pictureBox1.Refresh();
            double xpas = 0, ypas = 0;
            xpas = x1;
            ypas = f.eval(xpas, 0, 0);
            while (x1 < lsx)
            {
                x1 += paso;
                y1 = f.eval(x1, 0, 0);
                Application.DoEvents();
                Thread.Sleep(10);
                img1.DrawLine(red, xp(xpas, pictureBox1.Width, lix, lsx), yp(ypas, pictureBox1.Height, liy, lsy), xp(x1, pictureBox1.Width, lix, lsx), yp(y1, pictureBox1.Height, liy, lsy));
                xpas = x1; ypas = y1;     
            }

            img1.DrawLine(black, xp(0, pictureBox1.Width, lix, lsx), 0, xp(0, pictureBox1.Width, lix, lsx), pictureBox1.Height);
            img1.DrawLine(black, 0, yp(0, pictureBox1.Width, lix, lsx), pictureBox1.Width, yp(0, pictureBox1.Width, lix, lsx));

            Font pfont = new Font("Arial", 10);

            for (int i = Convert.ToInt32(lix); i <= lsx; i += Convert.ToInt32(paso*4))
            {
                img1.DrawString(Convert.ToString(xp(i, pictureBox1.Width, lix, lsx)), pfont, Brushes.Black, Convert.ToSingle(xp(0, pictureBox1.Width, lix, lsx) - 3), Convert.ToSingle(yp(0, pictureBox1.Height, liy, lsy) + 3));
            }
        }
    }
}
