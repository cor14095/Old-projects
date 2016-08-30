/*
Autor: Juan Luis Garcia Zarceno
Co-Autores: Freddie Batlle, Alejandro Cortes
Carne: 14189
Programacion Orientada a Objetos
06 de agosto del 2014
*/

import java.util.*;
import java.lang.*;//se importa la clase matematica
import java.awt.event.*;
import java.awt.*;

import javax.swing.JOptionPane;


public class Procedimientos {

    private Stack<Character> data = new Stack<Character>(); // Es unicamente para ordenar los signos dentro de la funcion
    private Stack<Double> evl = new Stack<Double>(); // Eval resuelve el postfix
	private double[] num = new double[99];  // 
	private double n = 0;
	private int i = 0, cont = 0;
    private boolean error = false;
	private String post = "";
    private String mainPol = "";
    private String subPol = "";
	
    public Procedimientos(String cadena) {//constructor
    	String t = "";
    	Boolean ts = false;
    	cadena = cadena.toLowerCase();    

        while (i < cadena.length()){
/*Si es un '('*/
        	if (cadena.charAt(i) == '(') { 
        		data.push(cadena.charAt(i++)); 
        		} else 
/*Si es un ')'*/
        			if (cadena.charAt(i) == ')') {
        				while ((data.size() != 0) && (data.peek() != '(' )) {
                            post += data.pop();
                        }
                        data.pop(); 
                        i++;
                    } else
/*Si es una letra reservada 'xyz'*/
                    	if ("xyz".indexOf(cadena.charAt(i)) != -1) {
                    		if (ts) { signo('*'); }
                    		post += cadena.charAt(i++);
                    		ts = true;
                    	} else
/*Si es un numero '0 - 9'*/
                    		if ("0123456789".indexOf(cadena.charAt(i)) != -1) {
                    			t = cadena.substring(i);
                    			
                    			MyVal(t,  n,  cont);
                    			if (cont != 0) {
                    				t = t.substring(0, cont);
                    				i += cont;
									//JOptionPane.showMessageDialog(null,t);
                    			} else { 
                    				i += cadena.length() + 1; 
                    				}
                    			post += '#';
                    			num[post.length() -1] = n;
                    			ts = true;
                    			cont = 0;
								//JOptionPane.showMessageDialog(null,t);
                    		} else
/*Si es un simbolo reservado*/
                    			if ("+-*/^~".indexOf(cadena.charAt(i)) != -1) {
                    				if (ts) {
                    					signo(cadena.charAt(i));
                    				} else {
                    					if (cadena.charAt(i) == '-') {
                    						signo('~');
                    					} else { 
                    						JOptionPane.showMessageDialog(null, "Error de sintaxis en el " + i + " espacio.", "Error", JOptionPane.ERROR_MESSAGE);
                    						i = cadena.length();
                    					}
                    				}
                    				ts = false; i++;
                    			} else
/*Si es una letra reservada*/
                    				if ("rsctle".indexOf(cadena.charAt(i)) != -1) {
                    					if (ts) { signo('*'); ts = false;}
                    					data.push(cadena.charAt(i));
                    					if (cadena.charAt(i) == 'e') {
                    						ts = true;
                    					}
                    					i++;
                    				} else
/*Si es un ' ' espacio en blanco*/
                    					if (cadena.charAt(i) == ' ') { 
                    						i++; 
                    					} else { 
                    						JOptionPane.showMessageDialog(null, "Error de sintaxis", "Error", JOptionPane.ERROR_MESSAGE);
                    						error = true; 
                    						i++; 
                    					}
        }

                if (error)
                {
                    post = "#";
                    num[0] = 0;
                }
                else
                {
                    while (data.size() != 0) { post += data.pop(); }
                }
                
                if (post.charAt(post.length()-1) == '/'){
                	subPol = cadena.substring(cadena.indexOf('/')+1);
                	mainPol = cadena.substring(0, cadena.indexOf('/'));
                } else {
                	mainPol = cadena;
                	subPol = "1";
                }
				//JOptionPane.showMessageDialog(null, "Error: "+post, "Error", JOptionPane.ERROR_MESSAGE); 
    }
    
    public void MyVal(String a,  double a1,  int a2) {
    	int b, c, d, e, cont1 = 1, cont2 = 0;
        String s1 = a;
        
        while (cont1 < s1.length()) {
        	b = (int)s1.charAt(cont1);
            c = 0;
            d = b - c;
            if ("0123456789".indexOf(d) != -1) {
            	a2 = 0;
            	this.cont = 0;
                cont1++;
                if (d == -2) {
                	cont2 += 1; 
                	e = s1.indexOf(s1.charAt(cont2)); 
                	if (cont2 > 1) {
                		JOptionPane.showMessageDialog(null, "Error ingreso dos puntos", "Error", JOptionPane.ERROR_MESSAGE); 
                        a2 = s1.indexOf(s1.charAt(cont2)); 
                        this.cont = s1.indexOf(s1.charAt(cont2));
                        cont1 = s1.length() + 1; 
                    	} 
                	}
                } else {
                	this.n = Double.parseDouble(s1.substring(0, cont1));
                    a2 = s1.indexOf(s1.charAt(cont1));
                    this.cont = s1.indexOf(s1.charAt(cont1));
                    cont1 = s1.length() + 1;
                    }
					
            }
        if (a2 == 0) { 
        	this.n = Double.parseDouble(a); 
        	}
        }

    private int jer(char c) {
    	return ("( +-*/^r~sctle".indexOf(c)) / 2;
    	}

    private void signo(char c) {
    	while ((data.size() != 0) && (jer(c) <= jer(data.peek()))) {
    		post += data.pop();
    		}
    	data.push(c);
    	}
					
    public double eval(double x, double y, double z) {
    	if (error) {
    		JOptionPane.showMessageDialog(null, "Error en el PostFix", "Error", JOptionPane.ERROR_MESSAGE); 
			return 0; 
			} else {
				evl.clear();
				for (int i = 0; i < post.length(); i++) {
					switch (post.charAt(i)) {
					case '#':
						evl.push(num[i]); 
                        break;
                    case 'x': 
                       	evl.push(x); 
                       	break;
                    case 'y': 
                       	evl.push(y); 
                       	break;
                    case 'z': 
                       	evl.push(z); 
                       	break;
                    case '+': 
                       	evl.push(evl.pop()+evl.pop()); 
                       	break;
                    case '~': 
                       	evl.push(-evl.pop()); 
                       	break;
                    case '-': 
                       	evl.push(-evl.pop() + evl.pop()); 
                       	break;
                    case '*': 
                       	evl.push(evl.pop() * evl.pop()); 
                       	break;
                    case '/': 
                       	if ((evl.peek()>= -0.0001)&&(evl.peek()<= 0.0001)) {
                       		/*asin[ca++] = x;
                       		evl.clear();
                       		i = post.length();
                       		evl.push(0.0);*/
                       		//JOptionPane.showMessageDialog(null, "Asintota en x = "+x, "Error", JOptionPane.ERROR_MESSAGE); 
                       		} else {
                       			double t1 = evl.pop(); 
                            	double t2 = evl.pop(); 
                            	evl.push(t2 / t1);
                            	}
                       	break;
                    case '^': 
                       	double t3 = evl.pop(); 
                       	double t4 = evl.pop(); 
                       	evl.push(Math.pow(t4, t3)); 
                       	break;
                    case 's': 
                       	evl.push(Math.sin(evl.pop()));
                       	break;
                    case 'c': 
                       	evl.push(Math.cos(evl.pop())); 
                       	break;
                    case 't': 
                    	try {
                    		evl.push(Math.tan(evl.pop())); 
                    	} catch (Exception e) {
                    		evl.pop();
                    		evl.push(0.0);
                    	}
                       	break;
                    case 'l':
                       	evl.push(Math.log10(evl.pop())); 
                       	break;
                    case 'e': 
                       	evl.push(Math.E); 
                       	break;
                    case 'r': 
                       	evl.push(Math.sqrt(evl.pop())); 
                       	break;
                       	}
					}
				
				if (evl.size() == 1) {
					return evl.peek();
					} else { 
						return evl.elementAt(1); 
						}
				}
    	}

	
/*---------------- Getters y Setters-----------------------*/
    
    public String getPost() {
		return post;
	}
    

	public void setPost(String post) {
		this.post = post;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getSubPol() {
		return subPol;
	}

	public void setSubPol(String subPol) {
		this.subPol = subPol;
	}

	public String getMainPol() {
		return mainPol;
	}

	public void setMainPol(String mainPol) {
		this.mainPol = mainPol;
	}
    

}