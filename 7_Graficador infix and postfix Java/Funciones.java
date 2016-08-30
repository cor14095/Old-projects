/*
Autores: Freddie Batlle, Alejandro Cortes
Co-Autor: Juan Luis Garcia Zarceno
Programacion Orientada a Objetos
06 de agosto del 2014
*/

import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;//se importa la clase matematica
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Funciones {

	private Procedimientos procs;
	private String expr;
	private double inti;
	private double intf;
	private JPanel drawP;
	private DecimalFormat formato = new DecimalFormat("####.##");
	

	public Funciones(String expr) {
		
		this.expr = expr;
		inti = 0;
		intf = 0;
		drawP = null;
		
		procs = new Procedimientos(expr);
		
	}
	
	public double eval(double x, double y, double z){
		return procs.eval(x,y,z);
	}
	
	public String getPost() {
		return procs.getPost();
	}
	
	public String secante(double inti, double intf, String expr){ 
		//parametros son los intervalos
		procs = new Procedimientos(expr);
		String sli = null; // Es el signo del limite inferior.
		String sls = null; // Es el signo del limite superior.
		double paso = (intf - inti)/10000;
		String r = "";
		double a = 0, b = 0, c = 0;
		
		while (inti <= intf) { //hasta que un intervalo sea igual al otro
			if (procs.eval(inti, 0, 0)<=-0.0000000001) { //Si es menor a 0 es negativo
				sli = "-";
			}  else if (procs.eval(inti, 0, 0)>=0.0000000001)  { //Si es mayor a 0 es positivo
				sli = "+";
				} else { // Si no es mayor ni menor a 0, es cero.
					r += formato.format(inti) + ",";
					inti += 0.1;
				}
			
			if (procs.eval(inti + paso, 0, 0)<=-0.0000000001) { //Si es menor a 0 es negativo
				sls = "-";
			}  else if (procs.eval(inti + paso, 0, 0)>=0.0000000001)  { //Si es mayor a 0 es positivo
				sls = "+";
				} else { // Si no es mayor ni menor a 0, es cero.
					r += formato.format((inti + paso)) + ",";
					inti += 0.1;
				}
			if (!(sli == null) && !(sls == null)) {
			
				if (!sli.equals(sls)){
					if (Math.abs(procs.eval(inti, 0, 0)) > (Math.abs(procs.eval(inti + paso, 0, 0))))
						a = inti + paso;
						else {
							a = inti;
						}
					while (!(procs.eval(a, 0, 0)<=0.000001)){
						c = a - (((a - b)/(procs.eval(a, 0, 0))-(procs.eval(b, 0, 0)))*(procs.eval(a,0,0)));
						b = a;
						a = c;
					}
					if ((a>=-0.0000001)&&(a<=0.0000001)) {
						r += "0,";
					} else {
						r += formato.format(a)+",";
					}
					inti = a;
				}
			}
			
			inti += paso;		
		}
		return r ; //problema porque no se sabra si 0 es un 0 o si dio 0 porque no encontro un 0
	}
	
	public String asintotas(double inti, double intf){
		expr = procs.getSubPol();
		
		if (procs.getSubPol() != "1") {
			return secante(inti, intf, expr);
		} else return "No hay asintotas V.";
	}
	
	public String ceros(double inti, double intf){
		expr = procs.getMainPol();
		
		return secante(inti, intf, expr);
	}
	
	public String asintotaH(){
		double izq = eval(-1000, 0, 0);
		double der = eval(1000, 0, 0);
		
		if (((izq<-1000)||(izq>1000)) && ((der<-1000)||(der>1000))){
			return " No hay asintota.";
		} else if (Math.round(izq) == Math.round(der)){
			return " "+Math.round(izq);
		} else if (Math.round(izq) != Math.round(der)) {
			return "Asintota oblicua"; // Falta armar la ecuacion de esta
		} else {
			JOptionPane.showMessageDialog(null, "DAAAAAM Nigga! Something whent full retarded!");
			return "";
		}
		
		
	}
	
}
	
