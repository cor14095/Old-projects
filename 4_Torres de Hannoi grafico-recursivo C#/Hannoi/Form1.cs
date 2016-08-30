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
        Graphics Canvas = null;
        Pen gris = new Pen(Color.Gray);
        int xmed, ypaso, x, y;
        int n = 0;
        public static TTorres[] Torres = new TTorres[3];

        public class TTorres
        {
            private Form f;
            private Button anillo;
            private Button[] Torre;
            private int sp;
            private int xmed, ypaso, x, y, siz;

            public int nt;

            public TTorres(Form form)
            {
                sp = 0;
                x = form.Size.Width;
                y = form.Size.Height;
                xmed = ((x - 100) / 3) - ((x - 100) / 12) + 25;
                ypaso = ((y - 200) - (y - 500)) / 10;
                Torre = new Button[10];
                f = form;
                siz = ((x - 100) / 3) - 80;
            }

            public void crearan()
            {
                this.anillo = new System.Windows.Forms.Button();
                this.anillo.Location = new System.Drawing.Point((xmed * 1) - ((siz - (10 * sp)) / 2), y - 500);
                this.anillo.Name = "Anillo";
                this.anillo.Size = new System.Drawing.Size(siz-(10*sp), 30);
                this.anillo.TabIndex = 0;
                this.anillo.Text = sp.ToString();
                this.anillo.UseVisualStyleBackColor = true;
                this.anillo.BackColor = Color.Gold;
                this.anillo.Parent = f;

                push(anillo, Torres[0]);
            }

            public void push(Button e, TTorres t)
            {
                if (t.sp <= 9)
                {
                    t.Torre[t.sp++] = e;
                    e.Left = (xmed * (t.nt + 1)) - ((siz - (10 * t.sp)) / 2);

                    for (int i = 1; i <= (10 - t.sp); i++)
                    {
                        e.Top = e.Top + ypaso;
                        Application.DoEvents();
                        Thread.Sleep(10);
                    }

                    e.Top = (y - 200) - (30 * t.sp) - 5;
                } else MessageBox.Show ("Stack overflow");
            }

            public Button pop(TTorres t)
            {
                if (t.sp > 0)
                {
                    t.sp--;

                    for (int i = 1; i <= (10 - t.sp); i++)
                    {
                        t.Torre[t.sp].Top = t.Torre[t.sp].Top - ypaso;
                        Application.DoEvents();
                        Thread.Sleep(10);
                    }

                    return t.Torre[t.sp];
                }
                else { MessageBox.Show("Stack overflow"); return null; }
            }
        
        }

        public void hanoi(int n, TTorres t1, TTorres t2, TTorres t3)
        {
            if (n == 1)
            {
                t3.push(t1.pop(t1), t3);
            }
            else
            {
                hanoi(n - 1, t1, t3, t2);
                hanoi(1    , t1, t2, t3);
                hanoi(n - 1, t2, t1, t3);
            }
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Canvas = this.CreateGraphics();
            Torres[0] = new TTorres(this);
            Torres[0].nt = 0;
            Torres[1] = new TTorres(this);
            Torres[1].nt = 1;
            Torres[2] = new TTorres(this);
            Torres[2].nt = 2;
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {

            if (Canvas != null)
            {
                x = this.Size.Width;
                y = this.Size.Height;
                xmed = ((x - 100) / 3) - ((x-100)/12) + 25;
                ypaso = ((y - 200) - (y - 500)) / 10;
                gris.Width = 10;

                /* Para hacer la "tabla" */
                Canvas.DrawLine(gris, 50, y - 150, x - 50, y - 150);
                Canvas.DrawLine(gris, 50, y - 200, x - 50, y - 200);
                Canvas.DrawLine(gris, 50, y - 200, 50, y - 150);
                Canvas.DrawLine(gris, x - 50, y - 200, x - 50, y - 150);
                /* Para hacer los postes */

                gris.Width = 25;
                
                /* Poste #1 */
                Canvas.DrawLine(gris, xmed * 1, y - 200, xmed * 1, y - 500);

                /* Poste #2 */
                Canvas.DrawLine(gris, xmed * 2, y - 200, xmed * 2, y - 500);

                /* Poste #3 */
                Canvas.DrawLine(gris, xmed * 3, y - 200, xmed * 3, y - 500);
            }
        }

        private void Form1_Resize(object sender, EventArgs e)
        {

            this.Canvas.Clear(this.BackColor);
            Canvas = this.CreateGraphics();
            this.Refresh();

            x = this.Size.Width;
            y = this.Size.Height;
            xmed = ((x - 100) / 3) - ((x - 100) / 12) + 25;
            ypaso = ((y - 200) - (y - 500)) / 10;
            gris.Width = 10;

            button1.Left = (Form.ActiveForm.Width / 2) - 175;
            button1.Top = y - 100;
            button2.Left = (Form.ActiveForm.Width / 2) - 50;
            button2.Top = y - 100;
            button3.Left = (Form.ActiveForm.Width / 2) + 50 + 25;
            button3.Top = y - 100;

            if (n == 0)
            {
                Torres[0] = new TTorres(this);
                Torres[0].nt = 0;
                Torres[1] = new TTorres(this);
                Torres[1].nt = 1;
                Torres[2] = new TTorres(this);
                Torres[2].nt = 2;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Torres[0].crearan();
            n++;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Torres[0].pop(Torres[0]).Dispose();
            n--;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (button3.Text == "Resolver")
            {
                button1.Enabled = false; button2.Enabled = false; button3.Enabled = false;
                hanoi(n, Torres[0], Torres[1], Torres[2]);
                button3.Enabled = true;
                button3.Text = "Reiniciar";
            }
            else
            {
                for (int i = 0; i < n; i++)
                {
                    Torres[2].pop(Torres[2]).Dispose();
                }

                Torres[0] = new TTorres(this);
                Torres[0].nt = 0;
                Torres[1] = new TTorres(this);
                Torres[1].nt = 1;
                Torres[2] = new TTorres(this);
                Torres[2].nt = 2;

                button1.Enabled = true; button2.Enabled = true; 
                button3.Text = "Resolver";
                n = 0;
            }
        }
    }
}
