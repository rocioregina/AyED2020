package ejercicio1;

public class TestContarHojasArbolBinario {
	
	public static void main(String[] args) {
		  ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(2);
		  ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>(7);
		  ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>(5);
		  arbol.agregarHijoIzquierdo(hijoIzq);
		  arbol.agregarHijoDerecho(hijoDer);
		  System.out.println("Cantidad de hojas del árbol: " + arbol.contarHojas());
	}
}
