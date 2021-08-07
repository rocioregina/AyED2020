package tp06.ejercicio1;
import tp02.ejercicio2.*;

public interface Grafo<T> {
	
	/*
	 * Agrega  un  vertice  al  Grafo.  Verifica  que  el  vertice  no exista en el Grafo.
	*/
	public void agregarVertice(Vertice<T> v);
	
	/*
	 * Elimina  el  vertice  del  Grafo.
	 * En  caso  que  el  vertice tenga conexiones con otros vertices, se eliminan todas sus conexiones.
	*/
	public void eliminarVertice(Vertice<T> v);
	
	/*
	 * Conecta  el  vertice origen con  el vertice destino.
	 * Verifica que ambos vertices existan, caso contrario no realiza ninguna conexion.
	*/
	public void conectar(Vertice<T> origen, Vertice<T> destino);
	
	/*
	 * Conecta  el  vertice origen con  el  vertice destino con peso.
	 * Verifica  que  ambos  vertices  existan,  caso  contrario  no  realiza ninguna conexion.
	*/
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso);
	
	/*
	 * Desconecta  el  vértice origencon  el destino.
	 * Verifica  que  ambos  vertices  y  la  conexion origen-->destino existan,  caso  contrario  no realiza  ninguna  desconexion.
	 * En  caso  de  existir  la  conexion destino-->origen,  esta  permanece  sin cambios.
	*/
	public void desconectar(Vertice<T> origen, Vertice<T> destino);
	
	/*
	 * Retorna  true  si origen es adyacente a destino. False en caso contrario. 
	 */
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino);
	
	/*
	 * Retorna true en caso que el grafo no contenga ningun vertice. False en caso contrario.
	 */
	public boolean esVacio();
	
	/*
	 * Retorna la lista con todos los vertices del grafo.
	 */
	public ListaGenerica<Vertice<T>> listaDeVertices();
	
	/*
	 * Retorna  el  peso  de  la  conexion origen-->destino. Si no existiera la conexion retorna 0.
	 */
	public int peso(Vertice<T> origen, Vertice<T> destino);
	
	/*
	 * Retorna  la  lista  de adyacentes de un vertice.
	 */
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v);
	
	/*
	 * Retorna el vertice dada su posicion.
	 */
	public Vertice<T> vertice(int posicion);
}
