package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class ColaGenerica<T> {
	
	private ListaEnlazadaGenerica<T> datos;
	
	public ColaGenerica(){
		this.datos = new ListaEnlazadaGenerica<T>();	
	}
	
	public void encolar(T elem) {
		this.datos.agregarFinal(elem);
	}
	
	public T desencolar() {
		T n = this.datos.elemento(1);
		this.datos.eliminarEn(1);
		return n;
	}
	
	public T tope() {
		return this.datos.elemento(1);
	}
	
	public boolean esVacia() {
		return this.datos.esVacia();
	}
}
