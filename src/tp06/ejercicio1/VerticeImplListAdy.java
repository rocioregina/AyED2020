package tp06.ejercicio1;
import tp02.ejercicio2.*;

public class VerticeImplListAdy<T> implements Vertice<T> {
	private T dato;
	private int posicion;
	private ListaEnlazadaGenerica<Arista<T>> adyacentes;
	
	public VerticeImplListAdy(T d) {
		dato = d;
		adyacentes = new ListaEnlazadaGenerica<Arista<T>>();
	}
	
	public ListaGenerica<Arista<T>> obtenerAdyacentes(){
		return adyacentes;
	}
	
	public void conectar(Vertice<T> v) {
		conectar(v, 1);
	}
	
	public void conectar(Vertice<T> v, int peso) {
		Arista<T> a = new AristaImpl<T>(v, peso);
		if(!adyacentes.incluye(a)) {
			adyacentes.agregarFinal(a);
		}
	}
	
	public void desconectar(Vertice<T> v) {
		Arista<T> a = obtenerArista(v);
		adyacentes.eliminar(a);
	}
	
	public boolean esAdyacente(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);

        return arista != null;
    }
	
	public int peso(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);

        int ret = 0;
        if (arista != null) {
            ret = arista.peso();
        }

        return ret;
    }
	
	public ListaGenerica<Arista<T>> getAdyacentes(){
		return adyacentes;
	}
	
	public T dato() {
		return this.dato;
	}
	
	public void setDato(T d) {
		dato = d;
	}
	
	public int getPosicion() {
		return this.posicion;
	}
	
	public void setPosicion(int pos) {
		posicion = pos;
	}
	
	private Arista<T> obtenerArista(Vertice<T> v) {
        Arista<T> arista = null;
        Arista<T> aristaAux;
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            aristaAux = adyacentes.proximo();
            if (aristaAux.verticeDestino() == v) {
                arista = aristaAux;
            }
        }
        return arista;
    }
}
