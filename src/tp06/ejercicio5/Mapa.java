package tp06.ejercicio5;

import tp06.ejercicio1.*;
import tp02.ejercicio2.*;

public class Mapa {
	
	Grafo<String> grafo;

    public Mapa(Grafo<String> grafo) {
        this.grafo = grafo;
    }
    
    //Metodo que busca el vertice origen que coincide con el dato ingresado como parametro.
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
    
    //Metodo que copia una lista.
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

    /*
     * Metodo que retorna la lista de ciudades a atravesar para ir de ciudad1 a ciudad2 en caso de poder llegar.
     * Sino, retorna una lista vacia.
     */
    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
        if (!grafo.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()+1];
            Vertice<String> origen = buscarOrigen(ciudad1, vertices);
            if (origen != null) {
                buscarCaminoDFS(origen, ciudad2, camino, caminoActual, visitados);
            } else {
                System.out.println("No se encontro el origen");
            }
        }
        return camino;
    }
    
    /*
     * DFS que busca el camino entre ciudad1 y ciudad2 y lo almacena en una lista de String.
     */
    private void buscarCaminoDFS(Vertice<String> vActual, String ciudad2, ListaGenerica<String> camino, ListaGenerica<String> caminoActual, boolean[] visitados) {
        visitados[vActual.getPosicion()] = true;
        caminoActual.agregarFinal(vActual.dato());
        if (!vActual.dato().equals(ciudad2)) {
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vActual);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Vertice<String> vSiguiente = adyacentes.proximo().verticeDestino();
                if (!visitados[vSiguiente.getPosicion()]) {
                    buscarCaminoDFS(vSiguiente, ciudad2, camino, caminoActual, visitados);
                }
            }
        } else {
            if (camino.esVacia()) {
                this.copiar(camino,caminoActual);
            }
        }
        caminoActual.eliminarEn(caminoActual.tamanio());
        visitados[vActual.getPosicion()] = false;
    }
    
    /*
     * Metodo que retorna la lista de ciudades que forman un camino  desde ciudad1 a ciudad2, sin pasar por las ciudades contenidas en la lista ciudades.
     * Si no existe el camino, retorna una lista vacia.
     */
    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
        if (!grafo.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()+1];
            Vertice<String> origen = buscarOrigen(ciudad1, vertices);
            if (!(origen == null)) {
                buscarCaminoExceptuandoDFS(origen, ciudad2, camino, caminoActual, visitados, ciudades);
            } else {
                System.out.println("No se encontro el origen");
            }
        }
        return camino;
    }

    /*
     * DFS que busca el camino entre ciudad1 y ciudad2 sin pasar por las ciudades restringidas y lo almacena en una lista de String.
     */
    private void buscarCaminoExceptuandoDFS(Vertice<String> vActual, String ciudad2, ListaGenerica<String> camino, ListaGenerica<String> caminoActual, boolean[] visitados, ListaGenerica<String> ciudades) {
        visitados[vActual.getPosicion()] = true;
        caminoActual.agregarFinal(vActual.dato());
        if (!vActual.dato().equals(ciudad2)) {
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vActual);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Vertice<String> vSiguiente = adyacentes.proximo().verticeDestino();
                if (!visitados[vSiguiente.getPosicion()] && (!ciudades.incluye(vSiguiente.dato()))) {
                    buscarCaminoExceptuandoDFS(vSiguiente, ciudad2, camino, caminoActual, visitados, ciudades);
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
    
    /*
     * Metodo que retorna la lista de ciudades que forman el camino mas corto desde ciudad1 a ciudad2 (evalua peso de aristas).
     * Si no existe el camino, retorna la lista vacia.
     */
    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
        if (!grafo.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()+1];
            Vertice<String> origen = buscarOrigen(ciudad1, vertices);
            if (!(origen == null)) {
                caminoMasCortoDFS(origen, ciudad2, camino, caminoActual, visitados, 0, 99999);
            } else {
                System.out.println("No se encontro el origen");
            }
        }
        return camino;
    }
    
    /*
     * DFS que busca el camino mas corto desde ciudad1 a ciudad2 (evalua peso de aristas).
     */
    private void caminoMasCortoDFS(Vertice<String> vActual, String ciudad2, ListaGenerica<String> camino, ListaGenerica<String> caminoActual, boolean[] visitados, int distanciaActual, int distanciaMinima) {
    	visitados[vActual.getPosicion()] = true;
        caminoActual.agregarFinal(vActual.dato());
        if(vActual.dato().equals(ciudad2)) {
        	if(distanciaActual < distanciaMinima) {
        		this.copiar(camino, caminoActual);
        		distanciaMinima = distanciaActual;
        	} else {
        		ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vActual);
                adyacentes.comenzar();
                while(!adyacentes.fin()) {
                	Arista<String> a = adyacentes.proximo();
                	if(!visitados[a.verticeDestino().getPosicion()]) {
                		caminoMasCortoDFS(a.verticeDestino(), ciudad2, camino, caminoActual, visitados, distanciaActual + a.peso(), distanciaMinima);
                	}
                }
        	}
        }
    }
    
    /*
     * Metodo que retorna la lista de ciudades que forman el recorrido desde ciudad1 a ciudad2 (sin carga de combustible).
     * Si no existe, retorna la lista vacia.
     */
    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
    	ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
        if (!grafo.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()+1];
            Vertice<String> origen = buscarOrigen(ciudad1, vertices);
            if (origen != null) {
                dfsSinCargar(origen, ciudad2, camino, caminoActual, visitados, tanqueAuto);
            } else {
                System.out.println("No se encontro el origen");
            }
        }
    	return camino;
    }
   
    /*
     * DFS que busca el camino desde ciudad1 a ciudad2 (evalua combustible del tanque).
     */
    private void dfsSinCargar(Vertice<String> vActual, String ciudad2, ListaGenerica<String> camino, ListaGenerica<String> caminoActual, boolean[] visitados, int tanqueAuto) {
    	visitados[vActual.getPosicion()] = true;
        caminoActual.agregarFinal(vActual.dato());
        if (!vActual.dato().equals(ciudad2)) {
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vActual);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Arista<String> a = adyacentes.proximo();
                if ((!visitados[a.verticeDestino().getPosicion()]) && (tanqueAuto - a.peso() >= 0)) {
                    dfsSinCargar(a.verticeDestino(), ciudad2, camino, caminoActual, visitados, tanqueAuto - a.peso());
                }
            }
        } else {
            if (camino.esVacia()) {
                this.copiar(camino,caminoActual);
            }
        }
        caminoActual.eliminarEn(caminoActual.tamanio());
        visitados[vActual.getPosicion()] = false;
    }
    
    /*
     * Metodo que retorna la lista de ciudades desde ciudad1 a ciudad2 teniendo en cuenta la cantidad minima de cargas de combustible posible.
     * Si no existe, retorna la lista vacia.
     */
    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
        if (!grafo.esVacio()) {
            int[] minCargas = new int[1];
            minCargas[0] = 9999;
            ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
            boolean[] visitados = new boolean[vertices.tamanio()+1];
            Vertice<String> origen = buscarOrigen(ciudad1, vertices);
            if (origen != null) {
                menorCargaDFS(origen, ciudad2, camino, caminoActual, visitados, tanqueAuto, tanqueAuto, 0, minCargas);
            } else {
                System.out.println("No se encontro el origen");
            }
        }
        return camino;
    }

    /*
     * DFS que busca el camino desde ciudad1 a ciudad2 cargando combustible la menor cantidad de veces posible.
     */
    private void menorCargaDFS(Vertice<String> vActual, String ciudad2, ListaGenerica<String> camino, ListaGenerica<String> caminoActual, boolean[] visitados, int tanqueActual, int topeDeTanque, int cargaActual, int[] minCargas) {
        visitados[vActual.getPosicion()] = true;
        caminoActual.agregarFinal(vActual.dato());
        if (!vActual.dato().equals(ciudad2)) {
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vActual);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Arista<String> adyacente = adyacentes.proximo();
                Vertice<String> vSiguiente = adyacente.verticeDestino();
                if (!visitados[vSiguiente.getPosicion()]) {
                    if ((tanqueActual < adyacente.peso()) && (topeDeTanque >= adyacente.peso())) {
                        menorCargaDFS(vSiguiente, ciudad2, camino, caminoActual, visitados, (topeDeTanque - adyacente.peso()), topeDeTanque, cargaActual + 1, minCargas);
                    } else {
                        if (tanqueActual >= adyacente.peso()) {
                            menorCargaDFS(vSiguiente, ciudad2, camino, caminoActual, visitados, (tanqueActual - adyacente.peso()), topeDeTanque, cargaActual, minCargas);
                        }
                    }
                }
            }
        } else {
            if (camino.esVacia() || (cargaActual < minCargas[0])) {
                this.copiar(camino,caminoActual);
                minCargas[0] = cargaActual;
            }
        }
        caminoActual.eliminarEn(caminoActual.tamanio());
        visitados[vActual.getPosicion()] = false;
    }
    
}
