package tp04.ejercicio1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio4.Maximo;

public class Ejercicio5 {
	//private ArbolGeneral<AreaEmpresa> datos;
	
	public Integer devolverMaximopromedio(ArbolGeneral<AreaEmpresa> arbol) {
    	Integer cont = 0; Integer nodos = 0; Maximo m = new Maximo(); m.setMax(0);
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
    	ArbolGeneral<AreaEmpresa> arb = null;
    	if(!arbol.esVacio()) {
    		cola.encolar(arbol);
    		cola.encolar(null);
    		while(!cola.esVacia()) {
    			arb = cola.desencolar();
    			if(arb!=null) {
    				cont = cont + arb.getDatoRaiz().getTardanza();
    				nodos++;
    				ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arb.getHijos();
    				if(!hijos.esVacia()) {
    					hijos.comenzar();
    	    			while(!hijos.fin()) {
    	    				cola.encolar(hijos.proximo());
    	    			}
    				}
    			} else if (arb==null && !cola.esVacia()) {
    				cola.encolar(null);
    				}
    			if(cont != 0 && arb==null) {
    				//System.out.println("cont: " + cont); System.out.println("nodos: " + nodos);
    				cont = cont/nodos;
    				nodos = 0;
    				if(cont > m.getMax()) {
    					m.setMax(cont);
    					//System.out.println("max: " + m.getMax());
    				}
    				cont = 0;
    			}
    		}
    	}
		return m.getMax();
	}
	
	public static void main(String[] args) {
		AreaEmpresa z = new AreaEmpresa(5);
		ArbolGeneral<AreaEmpresa> arbol = new ArbolGeneral<AreaEmpresa>(z);
		AreaEmpresa a = new AreaEmpresa(9);
		AreaEmpresa b = new AreaEmpresa(8);
		AreaEmpresa c = new AreaEmpresa(4);
		AreaEmpresa d = new AreaEmpresa(5);
		AreaEmpresa e = new AreaEmpresa(9);
		AreaEmpresa f = new AreaEmpresa(12);
		AreaEmpresa g = new AreaEmpresa(3);
		ArbolGeneral<AreaEmpresa> h1 = new ArbolGeneral<AreaEmpresa>(a);
		ArbolGeneral<AreaEmpresa> h2 = new ArbolGeneral<AreaEmpresa>(b);
		ArbolGeneral<AreaEmpresa> h3 = new ArbolGeneral<AreaEmpresa>(c);
		ArbolGeneral<AreaEmpresa> h4 = new ArbolGeneral<AreaEmpresa>(d);
		ArbolGeneral<AreaEmpresa> h5 = new ArbolGeneral<AreaEmpresa>(e);
		ArbolGeneral<AreaEmpresa> h6 = new ArbolGeneral<AreaEmpresa>(f);
		ArbolGeneral<AreaEmpresa> h7 = new ArbolGeneral<AreaEmpresa>(g);
		h4.agregarHijo(h7); //nivel 3
		h1.agregarHijo(h4); h1.agregarHijo(h5); h3.agregarHijo(h6); //nivel 2
		arbol.agregarHijo(h1); arbol.agregarHijo(h2); arbol.agregarHijo(h3); //nivel 1
		Ejercicio5 ej = new Ejercicio5();
		System.out.println(ej.devolverMaximopromedio(arbol));
	}
}
