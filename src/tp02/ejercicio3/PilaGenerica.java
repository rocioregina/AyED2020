package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class PilaGenerica<T>{
	
	private ListaGenerica<T> datos;
	
	public void apilar(T elem) {
		this.datos.agregarInicio(elem);
	}
	
	public T desapilar() {
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
