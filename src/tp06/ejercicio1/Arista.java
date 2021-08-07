package tp06.ejercicio1;

public interface Arista<T> {
	
	/*
	 * Retorna el vertice destino de la arista. 
	 */
	public Vertice<T> verticeDestino();
	
	/*
	 * Retorna el peso de la arista.
	 */
	public int peso();
}
