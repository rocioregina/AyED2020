package tp04.ejercicio1;
import tp02.ejercicio2.*;

public class ParcialPrueba2 {
	public Datos resolver(ArbolGeneral<Integer> arbol) {
		Datos d = new Datos(); int nivel = -1;
		if(!arbol.esVacio()) {encontrarPar(arbol, d, nivel);}
		return d;
	}
	
	public boolean encontrarPar(ArbolGeneral<Integer> a, Datos info, int nivel) {
		ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		nivel++;
		lHijos.comenzar();
		boolean encontre=false;
		if(!lHijos.esVacia()) {
			while(!lHijos.fin() && !encontre) {
				encontre = encontrarPar(lHijos.proximo(), info, nivel);
			}
		} else if(a.getDatoRaiz()%2 == 0) {
			info.setA(a.getDatoRaiz());
			info.setB(nivel);
			return true;
		}
		return encontre;
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> h1 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> h2 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> h3 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> h4 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> h5 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> h6 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> h7 = new ArbolGeneral<Integer>(8);
		h5.agregarHijo(h7); //nivel 3
		h1.agregarHijo(h4); h1.agregarHijo(h5); h3.agregarHijo(h6); //nivel 2
		arbol.agregarHijo(h1); arbol.agregarHijo(h2); arbol.agregarHijo(h3); //nivel 1
		//test
		ParcialPrueba2 p = new ParcialPrueba2();
		System.out.println(p.resolver(arbol).getDatos());
	}
}
