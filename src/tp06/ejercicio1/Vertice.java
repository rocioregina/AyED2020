package tp06.ejercicio1;

public interface Vertice<T> {
	
	/*
	 * Retorna el dato del vertice.
	 */
	public T dato();
	
	/*
	 * Setea el dato del vertice.
	 */
	public void setDato(T d);
	
	/*
	 * Retorna la posicion del vertice.
	 */
	public int getPosicion();
}
