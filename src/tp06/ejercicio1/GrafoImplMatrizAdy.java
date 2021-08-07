package tp06.ejercicio1;
import tp02.ejercicio2.*;

public class GrafoImplMatrizAdy<T> implements Grafo<T>{
	private int maxVertices;
	private ListaGenerica<Vertice<T>> vertices;
	private int[][] matrizAdy;
	
	public GrafoImplMatrizAdy(int maxVert) {
        // La matriz comienza en 1
        maxVertices = maxVert;
        vertices = new ListaEnlazadaGenerica<Vertice<T>>();
        matrizAdy = new int[maxVertices + 1][maxVertices + 1];
        for (int i = 1; i <= maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                matrizAdy[i][j] = 0;
            }
        }
    }
	
	public void agregarVertice(Vertice<T> v) {
		if(!vertices.incluye(v)) {
			((VerticeImplMatrizAdy<T>) v).setPosicion(vertices.tamanio() + 1);
			vertices.agregarFinal(v);
		}
	}
	
	public void eliminarVertice(Vertice<T> v) {
		if(vertices.incluye(v)) {
			int index = ((VerticeImplMatrizAdy<T>) v).getPosicion();
	        // Elimino la fila
	        for (int fila = index; fila <= vertices.tamanio(); fila++) {
	            matrizAdy[fila] = matrizAdy[fila + 1];
	        }
	        // Elimino la columna
	        for (int fila = 0; fila <= vertices.tamanio(); fila++) {
	            for (int col = index; col < vertices.tamanio(); col++) {
	                matrizAdy[fila][col] = matrizAdy[fila][col + 1];
	            }
	        }
			vertices.eliminar(v);
		}
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino) {
		conectar(origen, destino, 1);
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
		if((vertices.incluye(origen)) && (vertices.incluye(destino))) {
			matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino).getPosicion()] = peso;
		}
	}
	
	public void desconectar(Vertice<T> origen, Vertice<T> destino) {
		matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino).getPosicion()] = 0;
	}
	
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
		return matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino).getPosicion()] > 0;
	}
	
	public boolean esVacio() {
		return vertices.esVacia();
	}
	
	public ListaGenerica<Vertice<T>> listaDeVertices(){
		return vertices;
	}
	
	public int peso(Vertice<T> origen, Vertice<T> destino) {
		if(esAdyacente(origen, destino)) {
			return matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino).getPosicion()];
		}
		else return 0;
	}
	
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v){
		ListaGenerica<Arista<T>> ady = new ListaEnlazadaGenerica<Arista<T>>();
		int posVertice = ((VerticeImplMatrizAdy<T>) v).getPosicion();
		for(int i=1; i<=vertices.tamanio(); i++) {
			if(matrizAdy[posVertice][i] > 0) {
				Arista<T> arista = new AristaImpl<T>(vertices.elemento(i), matrizAdy[posVertice][i]);
				ady.agregarFinal(arista);
			}
		}
		return null;
	}
	
	public Vertice<T> vertice(int posicion){
		return vertices.elemento(posicion);
	}
}
