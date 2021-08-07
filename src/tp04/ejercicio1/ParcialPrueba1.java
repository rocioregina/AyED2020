package tp04.ejercicio1;
import ejercicio2.*;
import ejercicio1.*;

public class ParcialPrueba1 {
	
	public int postOrden(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> l) {
		int b=0; int c=0;
		if(!a.getHijoIzquierdo().esVacio()) {
			b = postOrden(a.getHijoIzquierdo(), l) + 1;
		}
		if(!a.getHijoDerecho().esVacio()) {
			c = postOrden(a.getHijoDerecho(), l) + 1;
		}
		if(b == c) {
			l.agregarFinal(a.getDatoRaiz());
		}
		return b+c;
	}
	
	public ListaEnlazadaGenerica<Integer> resolver(ArbolBinario<Integer> arbol){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		postOrden(arbol, lista);
		return lista;
	}
	
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
		  ParcialPrueba1 p = new ParcialPrueba1();
		  p.resolver(arbol).imprimir();
	}

}
