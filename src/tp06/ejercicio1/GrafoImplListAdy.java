package tp06.ejercicio1;
import tp02.ejercicio2.*;


public class GrafoImplListAdy<T> implements Grafo<T> {
	private ListaGenerica<Vertice<T>> vertices = new ListaEnlazadaGenerica<Vertice<T>>();
	
	public void agregarVertice(Vertice<T> v) {
		if(!vertices.incluye(v)) {
			((VerticeImplListAdy<T>) v).setPosicion(vertices.tamanio() + 1);
			vertices.agregarFinal(v);
		}
	}
	
	public void eliminarVertice(Vertice<T> v) {
		int indice = ((VerticeImplListAdy<T>)v).getPosicion();
		if(indice >=0){
			Vertice<T> vert;
			vertices.comenzar();
			while(!vertices.fin()){
				vert = vertices.proximo();
				desconectar(vert, v);
			}
			
			boolean salir = false;
			vertices.comenzar();
			while(!vertices.fin() && !salir){
				vert = vertices.proximo();
				if(vert.equals(v)){
					vertices.eliminar(vert);
					salir = true;
				}
			}

			for(;indice<vertices.tamanio();indice++){
				vert = vertices.elemento(indice);
				((VerticeImplListAdy<T>)vert).setPosicion(vert.getPosicion()-1);
			}
		}
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino) {
		conectar(origen, destino, 1);
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
		if(vertices.incluye(origen) && vertices.incluye(destino)) {
			((VerticeImplListAdy<T>) origen).conectar(destino, peso);
		}
	}
	
	public void desconectar(Vertice<T> origen, Vertice<T> destino) {
		((VerticeImplListAdy<T>) origen).desconectar(destino);
	}
	
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
		return ((VerticeImplListAdy<T>) origen).esAdyacente(destino);
	}
	
	public boolean esVacio() {
		return vertices.esVacia();
	}
	
	public ListaGenerica<Vertice<T>> listaDeVertices(){
		return vertices;
	}
	
	public int peso(Vertice<T> origen, Vertice<T> destino) {
		return ((VerticeImplListAdy<T>) origen).peso(destino);
	}
	
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v){
		return ((VerticeImplListAdy<T>) v).getAdyacentes();		
	}
	
	public Vertice<T> vertice(int posicion){
		return vertices.elemento(posicion);
	}
}
