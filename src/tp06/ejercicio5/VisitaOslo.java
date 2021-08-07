package tp06.ejercicio5;
import tp06.ejercicio1.*;
import tp02.ejercicio2.*;

public class VisitaOslo {
	private String inicial = "Ayuntamiento";
    
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
        if (!lugares.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()+1];
            Vertice<String> origen = buscarOrigen(inicial, vertices);
            if (!(origen == null)) {
                caminoOslo(lugares, origen, destino, maxTiempo, camino, caminoActual, visitados, lugaresRestringidos);
            } else {
                System.out.println("No se encontro el origen");
            }
        }
        return camino;
	}
	
	private void caminoOslo(Grafo<String> grafo, Vertice<String> vActual, String destino, int tiempo, ListaGenerica<String> camino, ListaGenerica<String> caminoActual, boolean[] visitados, ListaGenerica<String> lugaresRestringidos) {
		visitados[vActual.getPosicion()] = true;
        caminoActual.agregarFinal(vActual.dato());
        if (!vActual.dato().equals(destino)) {
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vActual);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
            	Arista<String> a = adyacentes.proximo();
                Vertice<String> vSiguiente = a.verticeDestino();
                if (!visitados[vSiguiente.getPosicion()] && (!lugaresRestringidos.incluye(vSiguiente.dato())) && (tiempo - a.peso() >= 0)) {
                    caminoOslo(grafo, vSiguiente, destino, tiempo, camino, caminoActual, visitados, lugaresRestringidos);
                }
            }
        } else {
            if (camino.esVacia()) {
                this.copiar(camino,caminoActual);
            }
        }
        caminoActual.eliminarEn(caminoActual.tamanio()); //borra el ultimo elemento de camino actual, en caso de no corresponder el vertice actual en el camino.
        visitados[vActual.getPosicion()] = false;
	}
	
	private Vertice<String> buscarOrigen(String ciudad, ListaGenerica<Vertice<String>> vertices) {
        Vertice<String> origen = null;
        Boolean encontre = false;
        vertices.comenzar();
        while ((!vertices.fin()) && (!encontre)) {
            Vertice<String> vSiguiente = vertices.proximo();
            if (vSiguiente.dato().equals(ciudad)) {
                origen = vSiguiente;
                encontre = true;
            }
        }
        return origen;
    }
	
	private void copiar(ListaGenerica<String> destino, ListaGenerica<String> aCopiar){
        destino.comenzar();
        while(!destino.fin()){
            destino.eliminarEn(1);
        }
        aCopiar.comenzar();
        while(!aCopiar.fin()){
            destino.agregarFinal(aCopiar.proximo());
        }
    }
}

