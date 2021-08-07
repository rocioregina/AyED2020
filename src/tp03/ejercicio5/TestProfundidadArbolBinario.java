package tp03.ejercicio5;

import ejercicio1.ArbolBinario;

public class TestProfundidadArbolBinario {
	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>(2);
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);
		ArbolBinario<Integer> hijoIzq2 = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> hijoDer2 = new ArbolBinario<Integer>(1);
		hijoIzq.agregarHijoIzquierdo(hijoIzq2);
		hijoIzq.agregarHijoDerecho(hijoDer2);
		ArbolBinario<Integer> hijoDer3 = new ArbolBinario<Integer>(8);
		hijoDer.agregarHijoDerecho(hijoDer3);
		ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario();
		prof.setDatos(arbol);
		System.out.println(prof.sumaElementosProfundidad(3));
	}
}
