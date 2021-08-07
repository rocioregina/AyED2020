package tp03.ejercicio3;
import ejercicio1.*;
import ejercicio2.*;

public class ContadorArbol {
	private ArbolBinario<Integer> datos;
	
	public void setArbol(ArbolBinario<Integer> a) {
		this.datos = a;
	}
	
	private ListaEnlazadaGenerica<Integer> paresInOrden(ListaEnlazadaGenerica<Integer> l, ArbolBinario<Integer> a){
		if(!a.esVacio()) {
			if(!a.getHijoIzquierdo().esVacio()) {
				this.paresInOrden(l, a.getHijoIzquierdo());
			}
			if(a.getDatoRaiz()%2 == 0) {
				l.agregarFinal(a.getDatoRaiz());
			}
			if(!a.getHijoDerecho().esVacio()) {
				this.paresInOrden(l, a.getHijoDerecho());
			}
		}
		return l;
	}
	
	private ListaEnlazadaGenerica<Integer> paresPostOrden(ListaEnlazadaGenerica<Integer> l, ArbolBinario<Integer> a){
		if(!a.esVacio()) {
			if(!a.getHijoIzquierdo().esVacio()) {
				this.paresPostOrden(l, a.getHijoIzquierdo());
			}
			if(!a.getHijoDerecho().esVacio()) {
				this.paresPostOrden(l, a.getHijoDerecho());
			}
			if(a.getDatoRaiz()%2 == 0) {
				l.agregarFinal(a.getDatoRaiz());
			}
		}
		return l;	
	}
	
	public ListaEnlazadaGenerica<Integer> numerosPares() {
		ListaEnlazadaGenerica<Integer> lis = new ListaEnlazadaGenerica<Integer>();
		ListaEnlazadaGenerica<Integer> lis2 = new ListaEnlazadaGenerica<Integer>();
		lis = this.paresInOrden(lis, this.datos);
		lis2 = this.paresPostOrden(lis2, this.datos);
		lis2.imprimir();
		System.out.println("---------");
		return lis;
	}
	
	public static void main(String[] args) {
			  ContadorArbol arbCont = new ContadorArbol();
			  ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(6);
			  ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>(3);
			  ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>(2);
			  arbol.agregarHijoIzquierdo(hijoIzq);
			  arbol.agregarHijoDerecho(hijoDer);
			  ArbolBinario<Integer> hijoIzq2 = new ArbolBinario<Integer>(4);
			  ArbolBinario<Integer> hijoDer2 = new ArbolBinario<Integer>(1);
			  hijoIzq.agregarHijoIzquierdo(hijoIzq2);
			  hijoIzq.agregarHijoDerecho(hijoDer2);
			  ArbolBinario<Integer> hijoIzq3 = new ArbolBinario<Integer>(5);
			  ArbolBinario<Integer> hijoDer3 = new ArbolBinario<Integer>(8);
			  hijoDer.agregarHijoIzquierdo(hijoIzq3);
			  hijoDer.agregarHijoDerecho(hijoDer3);
			  arbCont.setArbol(arbol);
			  arbCont.numerosPares().imprimir();
			  
	}
}
