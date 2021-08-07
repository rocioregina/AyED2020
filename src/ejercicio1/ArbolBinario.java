package ejercicio1;

import tp02.ejercicio3.*;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;
	
	public ArbolBinario() {
		
	}

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(null);
	}

	public boolean esVacio() {
		return this.getDatoRaiz() == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	
	public int contarHojas() {
		int cant=0;
		if(this.esHoja()) {
			cant++;
		}
		if (!this.getHijoIzquierdo().esVacio()) {
			cant= cant + this.getHijoIzquierdo().contarHojas();
		}
		if (!this.getHijoDerecho().esVacio()) {
			cant= cant + this.getHijoDerecho().contarHojas();
		}
			return cant;
	}
	
	public ArbolBinario<T> espejo(){
		ArbolBinario<T> nuevo = new ArbolBinario<T>(this.getDatoRaiz());
		if (!this.getHijoIzquierdo().esVacio()) {
			nuevo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		}
		if (!this.getHijoDerecho().esVacio()) {
			nuevo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}
		return nuevo;
	}
	
	public void imprimir() {
		System.out.println(this.getDatoRaiz());
		if (!this.getHijoIzquierdo().esVacio()) {
			this.getHijoIzquierdo().imprimir();
		}
		if (!this.getHijoDerecho().esVacio()) {
			this.getHijoDerecho().imprimir();
		}
	}
	
	public void entreNiveles(int n, int m) {
		ColaGenerica<T> cola = new ColaGenerica<T>();
		cola.encolar(this.getDatoRaiz());
		while(!cola.esVacia()) {
			System.out.println(cola.desencolar());
			if(!this.getHijoIzquierdo().esVacio()) {
				cola.encolar(this.getHijoIzquierdo().getDatoRaiz());
			}
			if(!this.getHijoDerecho().esVacio()) {
				cola.encolar(this.getHijoDerecho().getDatoRaiz());
			}
		}
	}
	
	public void recorridoPorNiveles(int n, int m) {
		int cont = 1;
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				if(cont>=n && cont<=m) {
					System.out.print(arbol.getDatoRaiz());
				}
				if(!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if(!arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			} else
				if(!cola.esVacia()) {
					cont++;
					System.out.println();
					cola.encolar(null);
				}
		}
	}
	
	public boolean lleno() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		boolean lleno = true;
		cola.encolar(this);
		int cant_nodos = 0;
		cola.encolar(null);
		int nivel = 0;
		while(!cola.esVacia() && lleno) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if(!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cant_nodos++;
				}
				if(!arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
					cant_nodos++;
				}
			} else if(!cola.esVacia()) {
				if(cant_nodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cant_nodos = 0;
				} else
					lleno = false;
			}
		}
		return lleno;
	}
}