package tp04.ejercicio1;

import tp02.ejercicio2.ListaGenerica;
import java.util.Scanner;

public class RedDeAguaPotable {
	private ArbolGeneral<Double> datos;
	
	public RedDeAguaPotable() {
		datos = new ArbolGeneral<Double>();	
	}
	
	public RedDeAguaPotable(ArbolGeneral<Double> a) {
		datos = a;
	}
	
	private void minimoCaudal(double c, ArbolGeneral<Double> a, Minimo m) {
		if(a!=null) {
			ListaGenerica<ArbolGeneral<Double>> lHijos = a.getHijos();
			if(!lHijos.esVacia()) {
				System.out.println("Valor de caudal: " + c);
				System.out.println("Cant hijos: " + lHijos.tamanio());
				c = c / lHijos.tamanio();
				lHijos.comenzar();
				while(!lHijos.fin()) {
					minimoCaudal(c, lHijos.proximo(), m);
				}
			} else if(c < m.getMin()) {
				m.setMin(c);
			}
		}
	}
	
	public double minimoCaudal() {
		Minimo min = new Minimo(); Scanner s = new Scanner(System.in); double caudal;
		System.out.print("Ingrese el caudal del caño maestro: ");
		caudal = s.nextDouble();
		s.close();
		System.out.println("--------------------------------------");
		minimoCaudal(caudal, this.datos, min);
		if(min.getMin()==99999) {
			return 0;
		}
		return min.getMin();
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Double> arbol = new ArbolGeneral<Double>(1.0);
		ArbolGeneral<Double> h1 = new ArbolGeneral<Double>(1.0);
		ArbolGeneral<Double> h2 = new ArbolGeneral<Double>(1.0);
		ArbolGeneral<Double> h3 = new ArbolGeneral<Double>(1.0);
		ArbolGeneral<Double> h4 = new ArbolGeneral<Double>(1.0);
		ArbolGeneral<Double> h5 = new ArbolGeneral<Double>(1.0);
		ArbolGeneral<Double> h6 = new ArbolGeneral<Double>(1.0);
		ArbolGeneral<Double> h7 = new ArbolGeneral<Double>(1.0);
		h4.agregarHijo(h7); //nivel 3
		h1.agregarHijo(h4); h1.agregarHijo(h5); h3.agregarHijo(h6); //nivel 2
		arbol.agregarHijo(h1); arbol.agregarHijo(h2); arbol.agregarHijo(h3); //nivel 1
		RedDeAguaPotable red = new RedDeAguaPotable(arbol);
		System.out.println("El minimo caudal recibido por una casa es: " + red.minimoCaudal());
		System.out.println("--------------------------------------");
	}
}
