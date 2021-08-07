package tp03.ejercicio5;
import ejercicio1.*;
import tp02.ejercicio3.ColaGenerica;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> datos;
	
	public void setDatos(ArbolBinario<Integer> a) {
		datos = a;
	}
	
	public int sumaElementosProfundidad(int p) {
		int cont = 0; int nivel = 1;
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(this.datos);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				if(nivel==p) {
					cont = cont + (arbol.getDatoRaiz());
				}
				if(!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if(!arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			} else
				if(!cola.esVacia()) {
					nivel++;
					System.out.println();
					cola.encolar(null);
				}
		}
		return cont;
	}
}
