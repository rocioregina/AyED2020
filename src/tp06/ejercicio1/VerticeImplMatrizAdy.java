package tp06.ejercicio1;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {
	private T dato;
	private int posicion;
	
	public T dato() {
		return dato;
	}
	public void setDato(T d) {
		this.dato = d;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int pos) {
		this.posicion = pos;
	}
}
