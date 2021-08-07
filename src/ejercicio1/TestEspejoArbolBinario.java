package ejercicio1;

public class TestEspejoArbolBinario {
	
	public static void main(String[] args) {
		  ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(2);
		  ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>(7);
		  ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>(5);
		  arbol.agregarHijoIzquierdo(hijoIzq);
		  arbol.agregarHijoDerecho(hijoDer);
		  ArbolBinario<Integer> hijoIzq2 = new ArbolBinario<Integer>(3);
		  ArbolBinario<Integer> hijoDer2 = new ArbolBinario<Integer>(1);
		  hijoIzq.agregarHijoIzquierdo(hijoIzq2);
		  hijoIzq.agregarHijoDerecho(hijoDer2);
		  
		  arbol.imprimir();
		  System.out.println("------------------");
		  arbol.espejo().imprimir();
	}
}
