package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio4.Maximo;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);
		
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());
			
		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}


	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	
	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));
			
		}

		return lista;
	}

	
	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	
	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);
				
			}
		}	

		
	}
	
	private void preOrden(ListaEnlazadaGenerica<T> l){
		if(!this.esVacio()) {
			l.agregarFinal(this.getDatoRaiz());
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			if(!lHijos.esVacia()) {
				while(!lHijos.fin()) {
					lHijos.proximo().preOrden(l);
				}
			}
		}
	}
	
    public ListaEnlazadaGenerica<T> preOrden(){
    	ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
    	this.preOrden(lis);
    	return lis;
    }
    
    private void postOrden(ListaEnlazadaGenerica<T> l) {
    	if(!this.esVacio()) {
    		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
    		lHijos.comenzar();
    		if(!lHijos.esVacia()) {
    			while(!lHijos.fin()) {
    				lHijos.proximo().postOrden(l);
    			}
    		}
    		l.agregarFinal(this.getDatoRaiz());
    	}
    }
    
    public ListaEnlazadaGenerica<T> postOrden(){
    	ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
    	this.postOrden(lis);
    	return lis;
    }
    
    private void inOrden(ListaEnlazadaGenerica<T> l) {
    	if(!this.esVacio()) {
    		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
    		lHijos.comenzar();
    		if(!lHijos.esVacia()) {
    			lHijos.proximo().inOrden(l);
    		}
    		l.agregarFinal(this.getDatoRaiz());
    		if(!lHijos.esVacia()) {
    			while(!lHijos.fin()) {
    				lHijos.proximo().inOrden(l);
    			}
    		}
    	}
    }
    
    public ListaEnlazadaGenerica<T> inOrden(){
    	ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
    	this.inOrden(lis);
    	return lis;
    }
    
    public ListaEnlazadaGenerica<ArbolGeneral<T>> recorridoPorNiveles(){
    	ListaEnlazadaGenerica<ArbolGeneral<T>> lis = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
    	ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
    	ArbolGeneral<T> arb = null;
    	if(!this.esVacio()) {
    		cola.encolar(this);
    		cola.encolar(null);
    		while(!cola.esVacia()) {
    			arb = cola.desencolar();
    			if(arb!=null) {
    				lis.agregarFinal(arb);
    				ListaGenerica<ArbolGeneral<T>> hijos = arb.getHijos();
    				if(!hijos.esVacia()) {
    					hijos.comenzar();
    	    			while(!hijos.fin()) {
    	    				cola.encolar(hijos.proximo());
    	    			}
    				}
    			} else if (arb==null && !cola.esVacia()) {
    				cola.encolar(null);
    			}
    		}
    	}
    	return lis;
    }
    
    private ArbolGeneral<T> encontrarA(T a) {
    	if(!this.esVacio()) {
    		if(a.equals(this.getDatoRaiz())){
    			return this;
    		} else
    			if(!this.getHijos().esVacia()) {
    				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
    				hijos.comenzar();
    				hijos.proximo().encontrarA(a);
    			}
    	}
    	return null;
    }
    
    private boolean encontrarB(T b) {
    	boolean encontre = false;
    	if(!this.esVacio()) {
    		if(b.equals(this.getDatoRaiz())){
    			return true;
    		} else
    			if(!this.getHijos().esVacia()) {
    				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
    				hijos.comenzar();
    				while(!hijos.fin() && encontre == false) {
    					encontre = hijos.proximo().encontrarB(b);
    				}
    			}
    	}
    	return encontre;
    }
    
    public Boolean esAncestro(T a, T b) {
    	ArbolGeneral<T> aux = new ArbolGeneral<T>();
    	if(!this.esVacio()) {
    		aux = this.encontrarA(a);
    		if(aux != null) {
    			return aux.encontrarB(b);
    		}
    	}
    	return false;
    }
    
    private void altura(int cont, Maximo m) {
		if(this.esHoja()) {
			if(cont > m.getMax()) {
				m.setMax(cont);
			}
		}
		if(!this.getHijos().esVacia()) {
			cont++;
			this.getHijos().proximo().altura(cont, m);
		}
    }
    
	public int altura() {	 
		Maximo max = new Maximo();
		this.altura(0, max);
		if(max.getMax() <= 0) {
			max.setMax(max.getMax()-1);
		}
	   return max.getMax();
	}

	
	public Integer nivel( T dato){
		//falta implementar
	   return -1;
	}


	public Integer ancho(){
	   //Falta implementar..
	   return 0;
	}

	public boolean esHoja(){
		return this.getDatoRaiz() != null && this.getHijos().esVacia();
	}
	
	public boolean esVacio(){
		return this.getDatoRaiz() == null;
	}
}
