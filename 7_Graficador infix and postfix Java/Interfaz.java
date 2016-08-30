/*
Autores: Freddie Batlle, Alejandro Cortes
Co-Autor: Juan Luis Garcia Zarceno
Programacion Orientada a Objetos
06 de agosto del 2014
*/

import javax.swing.*;

import java.text.*; // Para poner el formato al decimal
import java.awt.event.*;
import java.awt.*;

import javax.swing.border.LineBorder;

public class Interfaz {

	private JFrame frame;
	private JTextField textField;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JCheckBox chckbxDerivada;
	private JCheckBox chckbxResolver;
	private JCheckBox chckbxGraficar;
	private JCheckBox chckbxAsintotasV;
	private JCheckBox chckbxAsintotaH;
	private JLabel lblFuncin;
	private JButton btnContinuar;
	private JLabel lblDerivada;
	private JLabel lblSoluciones;
	private JLabel lblAsintotasV;
	private JLabel lblAsintotaH;
	private double interv1;
	private double interv2;
	private String[] asin = new String[99];
	private JPanel panel;
	private DecimalFormat formato = new DecimalFormat("####.##");
	private JPanel panel_1;
	private JButton btnmas;
	private JButton btnmenos;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*-----------------------------------------------------------PANLE 1 y sus cosas*/
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{275, 379, 0};
		gridBagLayout.rowHeights = new int[]{70, 78, 320, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		panel1 = new JPanel();
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.gridwidth = 2;
		gbc_panel1.weighty = 1.0;
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.insets = new Insets(0, 0, 5, 0);
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 0;
		gbc_panel1.weightx = 1;
		
		frame.getContentPane().add(panel1, gbc_panel1);
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{644, 0};
		gbl_panel1.rowHeights = new int[]{20, 26, 0};
		gbl_panel1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel1.setLayout(gbl_panel1);
		
		lblFuncin = new JLabel("Funci\u00F3n:");
		lblFuncin.setFont(new Font("DialogInput", Font.BOLD, 14));
		GridBagConstraints gbc_lblFuncin = new GridBagConstraints();
		gbc_lblFuncin.weightx = 1.0E-4;
		gbc_lblFuncin.weighty = 1.0E-5;
		gbc_lblFuncin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFuncin.insets = new Insets(0, 0, 5, 0);
		gbc_lblFuncin.gridx = 0;
		gbc_lblFuncin.gridy = 0;
		panel1.add(lblFuncin, gbc_lblFuncin);
		
		textField = new JTextField();
		textField.setFont(new Font("DialogInput", Font.PLAIN, 12));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.weightx = 0.1;
		gbc_textField.weighty = 1.0E-5;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		/*------------------------------------------------------------PANEL 2 y sus cosas*/
		
		panel2 = new JPanel();
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.insets = new Insets(0, 0, 5, 5);
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 1;
		gbc_panel2.weightx = 1;
		gbc_panel2.weighty = 1.0;
		frame.getContentPane().add(panel2, gbc_panel2);
		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[]{69, 83, 97, 0};
		gbl_panel2.rowHeights = new int[]{23, 23, 0};
		gbl_panel2.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel2.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel2.setLayout(gbl_panel2);
		
		chckbxResolver = new JCheckBox("Resolver");
		chckbxResolver.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_chckbxResolver = new GridBagConstraints();
		gbc_chckbxResolver.weighty = 1.0;
		gbc_chckbxResolver.weightx = 1.0;
		gbc_chckbxResolver.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxResolver.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxResolver.gridheight = 2;
		gbc_chckbxResolver.gridx = 0;
		gbc_chckbxResolver.gridy = 0;
		panel2.add(chckbxResolver, gbc_chckbxResolver);
		
		chckbxDerivada = new JCheckBox("Derivada");
		chckbxDerivada.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_chckbxDerivada = new GridBagConstraints();
		gbc_chckbxDerivada.anchor = GridBagConstraints.NORTH;
		gbc_chckbxDerivada.weighty = 1.0;
		gbc_chckbxDerivada.weightx = 1.0;
		gbc_chckbxDerivada.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxDerivada.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDerivada.gridx = 0;
		gbc_chckbxDerivada.gridy = 0;
		panel2.add(chckbxDerivada, gbc_chckbxDerivada);
		
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new BListener());
		
		chckbxAsintotasV = new JCheckBox("Asintotas V.");
		chckbxAsintotasV.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_chckbxAsintotasV = new GridBagConstraints();
		gbc_chckbxAsintotasV.anchor = GridBagConstraints.NORTH;
		gbc_chckbxAsintotasV.weightx = 1.0;
		gbc_chckbxAsintotasV.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxAsintotasV.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAsintotasV.gridx = 1;
		gbc_chckbxAsintotasV.gridy = 0;
		panel2.add(chckbxAsintotasV, gbc_chckbxAsintotasV);
		
		chckbxAsintotaH = new JCheckBox("Asintota H.");
		chckbxAsintotaH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_chckbxAsintotaH = new GridBagConstraints();
		gbc_chckbxAsintotaH.weightx = 1.0;
		gbc_chckbxAsintotaH.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxAsintotaH.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxAsintotaH.gridheight = 2;
		gbc_chckbxAsintotaH.gridx = 1;
		gbc_chckbxAsintotaH.gridy = 0;
		panel2.add(chckbxAsintotaH, gbc_chckbxAsintotaH);
		btnContinuar.setFont(btnContinuar.getFont().deriveFont(btnContinuar.getFont().getSize() + 1f));
		GridBagConstraints gbc_btnContinuar = new GridBagConstraints();
		gbc_btnContinuar.weightx = 1.0;
		gbc_btnContinuar.ipady = 1;
		gbc_btnContinuar.fill = GridBagConstraints.BOTH;
		gbc_btnContinuar.gridheight = 2;
		gbc_btnContinuar.gridx = 2;
		gbc_btnContinuar.gridy = 0;
		panel2.add(btnContinuar, gbc_btnContinuar);
		
		chckbxGraficar = new JCheckBox("Graficar");
		chckbxGraficar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_chckbxGraficar = new GridBagConstraints();
		gbc_chckbxGraficar.weightx = 1.0;
		gbc_chckbxGraficar.fill = GridBagConstraints.BOTH;
		gbc_chckbxGraficar.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxGraficar.gridx = 0;
		gbc_chckbxGraficar.gridy = 1;
		panel2.add(chckbxGraficar, gbc_chckbxGraficar);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		
		btnmas = new JButton("+");
		btnmas.setBounds(157, 53, 41, 23);
		panel_1.add(btnmas);
		
		btnmenos = new JButton("-");
		btnmenos.setBounds(201, 53, 47, 23);
		panel_1.add(btnmenos);
		panel3 = new JPanel();
		GridBagConstraints gbc_panel3 = new GridBagConstraints();
		gbc_panel3.anchor = GridBagConstraints.NORTH;
		gbc_panel3.weightx = 1.0;
		gbc_panel3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel3.insets = new Insets(0, 0, 0, 5);
		gbc_panel3.gridx = 0;
		gbc_panel3.gridy = 2;
		frame.getContentPane().add(panel3, gbc_panel3);
		GridBagLayout gbl_panel3 = new GridBagLayout();
		gbl_panel3.columnWidths = new int[]{255, 0};
		gbl_panel3.rowHeights = new int[]{44, 42, 45, 20, 26, 0};
		gbl_panel3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel3.setLayout(gbl_panel3);
		
		
		
		lblDerivada = new JLabel("Derivada:");
		lblDerivada.setFont(new Font("DialogInput", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDerivada = new GridBagConstraints();
		gbc_lblDerivada.weighty = 1.0;
		gbc_lblDerivada.weightx = 1.0;
		gbc_lblDerivada.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDerivada.insets = new Insets(0, 0, 5, 0);
		gbc_lblDerivada.gridx = 0;
		gbc_lblDerivada.gridy = 0;
		panel3.add(lblDerivada, gbc_lblDerivada);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("DialogInput", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.weighty = 1.0;
		gbc_textField_1.weightx = 1.0;
		gbc_textField_1.anchor = GridBagConstraints.SOUTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		panel3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblSoluciones = new JLabel("Soluciones:");
		lblSoluciones.setFont(new Font("DialogInput", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSoluciones = new GridBagConstraints();
		gbc_lblSoluciones.weighty = 1.0;
		gbc_lblSoluciones.weightx = 1.0;
		gbc_lblSoluciones.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSoluciones.insets = new Insets(0, 0, 5, 0);
		gbc_lblSoluciones.gridx = 0;
		gbc_lblSoluciones.gridy = 1;
		panel3.add(lblSoluciones, gbc_lblSoluciones);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("DialogInput", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.weighty = 1.0;
		gbc_textField_2.weightx = 1.0;
		gbc_textField_2.anchor = GridBagConstraints.SOUTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 1;
		panel3.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("DialogInput", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.weighty = 1.0;
		gbc_textField_3.weightx = 1.0;
		gbc_textField_3.anchor = GridBagConstraints.SOUTH;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 2;
		panel3.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblAsintotasV = new JLabel("Asintotas V:");
		lblAsintotasV.setFont(new Font("DialogInput", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAsintotasV = new GridBagConstraints();
		gbc_lblAsintotasV.weightx = 1.0;
		gbc_lblAsintotasV.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAsintotasV.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsintotasV.gridx = 0;
		gbc_lblAsintotasV.gridy = 2;
		panel3.add(lblAsintotasV, gbc_lblAsintotasV);
		
		lblAsintotaH = new JLabel("Asintota H:");
		lblAsintotaH.setFont(new Font("DialogInput", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAsintotaH = new GridBagConstraints();
		gbc_lblAsintotaH.weightx = 1.0;
		gbc_lblAsintotaH.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAsintotaH.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsintotaH.gridx = 0;
		gbc_lblAsintotaH.gridy = 3;
		panel3.add(lblAsintotaH, gbc_lblAsintotaH);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("DialogInput", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.weighty = 1.0;
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 4;
		panel3.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(SystemColor.control);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);
		
		chckbxDerivada.addMouseListener(new Colorsitos());
		chckbxResolver.addMouseListener(new Colorsitos());
		chckbxGraficar.addMouseListener(new Colorsitos());
		chckbxAsintotasV.addMouseListener(new Colorsitos());
		chckbxAsintotaH.addMouseListener(new Colorsitos());
		btnmenos.addActionListener(new Zoom());
		btnmas.addActionListener(new Zoom());
		
		
	}
	
	public void graficar (double inti,double intf){
		
		Funciones f = new Funciones(textField.getText());
		Graphics2D graph = (Graphics2D)panel.getGraphics();
		
		int w = panel.getWidth();
		int h = panel.getHeight();
		double paso = (intf - inti)/1000;
		double x1 = inti, x2 = x1 + paso, y1 = f.eval(x1, 0, 0), y2 = f.eval(x2, 0, 0);
		Double yg = new Double(y2);
		
		//Limites en y para graficar bonito
		double liy = y1, lsy = y1;
		Double yy = new Double(y1);
		
		if(yy.isNaN() == true){
			liy = 0;
		}
		if (yy.isNaN() == true){
			lsy = 0;
		}
		
		while (x1 <= intf) {
			
			x1 = x1 + paso;
            y1 = f.eval(x1, 0, 0);

            if (y1 < liy) { 
            	liy = y1;
            }
            if (y1 > lsy){ 
            	lsy = y1;
            }
            	
		}
		yy = new Double(y1);
		
		if(y1< -1000|| yy.isNaN() == true){
			liy = -1000;
		}
		if (y1>1000 || yy.isNaN() == true){
			lsy = 1000;
		}
		
		x1 = inti;
		y1 = f.eval(x1, 0, 0);
		graph.setColor(Color.BLUE);
		
		int x1a, x2a, y1a, y2a;
		//JOptionPane.showMessageDialog(null, lsy + "aquib " + liy);
		
		graph.clearRect(0, 0, w, h);
		
		while (x1<=intf){
			
			x1a = ajusteX(x1, w-10, inti, intf);
			x2a = ajusteX(x2, w-10, inti, intf);
			y1a = ajusteY(y1, h-10, liy, lsy);
			y2a = ajusteY(y2, h-10, liy, lsy);		
			
			graph.drawLine( x1a, y1a, x2a, y2a);
			
			x1 = x2;
			x2 += paso;
			
			y1 = y2;
			y2 = f.eval(x2, 0, 0);
			yg = new Double(y2);
			if ((yg.isNaN()) || yg.isInfinite() || (ajusteY(y2, h-10, liy, lsy)>(h-10)) || (ajusteY(y2, h-10, liy, lsy)<0) ) {
				x2+= paso;
				y2 = f.eval(x2, 0, 0);
			}
		}
		
		graph.setColor(Color.BLACK);
		// Linea del eje y
		graph.drawLine(ajusteX(0, w-10, inti, intf), 0, ajusteX(0, w-10, inti, intf), h-10);
		// Linea del eje x
		graph.drawLine(0, ajusteY(0, h-10, liy, lsy), w-10, ajusteY(0, h-10, liy, lsy));
		
		paso = (intf-inti)/10;
		double i = inti;
		
		while (i <= intf) {
			
			//Escala en el eje x 
			graph.drawString(formato.format(i)+"", ajusteX(i, w-10,inti,intf) , ajusteY(0, h-10, liy, lsy));
			//Escala en el eje y
			graph.drawString(formato.format(i)+"", ajusteX(0, w-10,inti,intf) , ajusteY(i, h-10, liy, lsy));
			
			i += paso;
			
		}
		
		
	}

		/*Codigo para graficar*/
	
	private class Zoom implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().toString().indexOf("text=+") != -1) {  // menos
				interv1 /= 2;
				interv2 /= 2;
				graficar(interv1,interv2);	
			}
			else {
				interv1 *= 2;
				interv2 *= 2;
				graficar(interv1,interv2);
			}
		}
		
	}
	
	public int ajusteX(double x, double w, double inti, double intf){
		return (int)Math.round(( ((x-inti)*w)/(intf-inti) ));
	}
	
	public int ajusteY(double y, double h, double inti, double intf){
		return (int)Math.round(( ((intf-y)*h)/(intf-inti) ));
	}
	
	
	private class Colorsitos implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (!e.getComponent().getBackground().equals(Color.ORANGE))
				e.getComponent().setBackground(Color.ORANGE);
			else e.getComponent().setBackground(null);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if (!e.getComponent().getBackground().equals(Color.ORANGE))
				e.getComponent().setBackground(Color.ORANGE);
			else e.getComponent().setBackground(null);
		}

		
	}

	private class BListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			int b = 0;
			while(b == 0) {
				if (textField.getText().equals("") || textField.getText().equals(null)){
					JOptionPane.showMessageDialog(null,"Ingrese una funcion" ,"Error",0);
					b=1;
					break;
				}
				interv1 = (-50);
				interv2 = (50);
				
				
				Funciones f = new Funciones(textField.getText());
				//codigo para intervalo
				
				if (f.getPost().equals("-1")) {
					break;
				}
				
				String intervalo = "";
				String[] interv= {"0","0"};
				int a = 1;
				int opcion = JOptionPane.showConfirmDialog(null,"Desea usar un intervalo?");
				
				switch (opcion){
				case 0:
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					
					while (a == 1)
						try {
							intervalo = JOptionPane.showInputDialog("Ingrese su intervalo separado por comas");
							interv = intervalo.split(","); //separa el string(a partir de la ',') generado en el inputbox en un array 
							interv1 = Double.parseDouble(interv[0]);
							interv2 = Double.parseDouble(interv[1]); //string a integer
							if (interv1>interv2){
								interv1 = Double.parseDouble(interv[1]);
								interv2 = Double.parseDouble(interv[0]);
							}
							a = 0; //hasta que logre hacer todo el try
						} catch (NumberFormatException|ArrayIndexOutOfBoundsException w) { 
							//dos tipos de erores separados por |
							}
					break;
				case 1:
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					interv1 = (-50);
					interv2 = (50);
					break;
				case 2:
					a = 3;
					break;
				}
				
				if (a != 3) {
				
					if (chckbxDerivada.isSelected() == true) {
						/*Codigo para derivar*/
						
					}
					if (chckbxResolver.isSelected() == true) {
						/*Codigo para mostrar los ceros*/
						f = new Funciones(textField.getText());
						
					
						textField_2.setText((f.ceros(interv1, interv2)));
						if (textField_2.getText().equals("")){
							JOptionPane.showMessageDialog(null, "No tiene raices reales");
						}
						
					}
					
					if (chckbxAsintotasV.isSelected() == true) {
						/*Codigo para mostrar las asintotas Verticales*/
						f = new Funciones(textField.getText());
						
						textField_3.setText((f.asintotas(interv1, interv2))+"");
						if (!textField_3.getText().equals("No hay asintotas V.")) {
							asin = textField_3.getText().split(",");
						} else { asin = new String[1]; }
						
					}
					
					if (chckbxAsintotaH.isSelected() == true) {
						/*Codigo para mostrar la asintota Horizontal*/
						f = new Funciones(textField.getText());
						
						textField_4.setText((f.asintotaH())+"");
					}
					
					if (chckbxGraficar.isSelected() == true) {
						graficar(interv1,interv2);
				}
				}
				if ((!chckbxGraficar.isSelected()) && (!chckbxDerivada.isSelected()) && (!chckbxResolver.isSelected()) && (!chckbxAsintotasV.isSelected()) && (!chckbxAsintotaH.isSelected())){
					JOptionPane.showMessageDialog(null, "Seleccione un campo");
					break;
				}
				b = 1;
			}
		}
	}
}
