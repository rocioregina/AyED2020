package tp04.ejercicio1;
//import tp02.ejercicio2.*;

public class TestArbolGeneral {
	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> h1 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> h2 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> h3 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> h4 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> h5 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> h6 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> h7 = new ArbolGeneral<Integer>(8);
		h4.agregarHijo(h7); //nivel 3
		h1.agregarHijo(h4); h1.agregarHijo(h5); h3.agregarHijo(h6); //nivel 2
		arbol.agregarHijo(h1); arbol.agregarHijo(h2); arbol.agregarHijo(h3); //nivel 1
		//test
		System.out.println("Prueba 1: " + arbol.esAncestro(1, 7));
		System.out.println("Prueba 2: " + arbol.esAncestro(2, 4));
	}
}
