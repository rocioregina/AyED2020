package tp06.ejercicio5;
import tp02.ejercicio2.*;
import tp06.ejercicio1.*;
import tp02.ejercicio3.ColaGenerica;

public class Recorridos<T> {
	
	//A continuacion, se encuentra el recorrido DFS y sus variantes.
	
	/*
	 * Recorrido DFS.
	 */
	public void dfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		for(int i=1; i<=grafo.listaDeVertices().tamanio(); i++) {
			if(!marca[i]) {
				this.dfs(i, grafo, marca);
			}
		}
	}
	
	private void dfs(int i, Grafo<T> grafo, boolean[] marca) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		System.out.println(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if(!marca[j]) {
				this.dfs(j, grafo, marca);
			}
		}
	}
	
	/*
	 * DFS que devuelve una lista con los elementos visitados.
	 */
	public ListaGenerica<Vertice<T>> dfsLista(Grafo<T> grafo){
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		for(int i=1; i<=grafo.listaDeVertices().tamanio(); i++) {
			if(!visitados[i]) {
				this.dfsLista(i, grafo, lis, visitados);
			}
		}
		return lis;
	}
	
	private void dfsLista(int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lis, boolean[] visitados) {
		visitados[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lis.agregarEn(v, lis.tamanio());
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if(!visitados[j]) {
				this.dfsLista(j, grafo, lis, visitados);
			}
		}
	}
	
	/*
	 * DFS con costo. Devuelve una lista (de listas de vertices) con los recorridos de un costo especifico.
	 */
	public ListaGenerica<ListaEnlazadaGenerica<Vertice<T>>> dfsConCosto(Grafo<T> grafo) {
		boolean[]marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<Vertice<T>> lis = null;
		ListaGenerica<ListaEnlazadaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Vertice<T>>>();
		int costo = 0;
		for(int i=1; i<=grafo.listaDeVertices().tamanio(); i++) {
			lis = new ListaEnlazadaGenerica<Vertice<T>>();
			lis.agregarFinal(grafo.listaDeVertices().elemento(i));
			marca[i] = true;
			this.dfsConCosto(i, grafo, lis, marca, costo, recorridos);
			marca[i] = false;
		}
		return recorridos;
	}
	
	private void dfsConCosto(int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lis, boolean[] marca, int costo, ListaGenerica<ListaEnlazadaGenerica<Vertice<T>>> recorridos) {
		Vertice<T> vDestino = null; int p=0, j=0;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<T> arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();
			if(!marca[j]) {
				p = arista.peso();
				if((costo+p)<=10) {
					vDestino = arista.verticeDestino();
					lis.agregarFinal(vDestino);
					marca[j] = true;
					if((costo+p) == 10) {
						recorridos.agregarFinal(lis.clonar());
					} else
						this.dfsConCosto(j, grafo, lis, marca, costo+p, recorridos);
					lis.eliminar(vDestino);
					marca[j] = false;
				}
			}
		}
	}
	
	//A continuacion, se encuentra el recorrido BFS y sus variantes.
	
	/*
	 * Recorrido BFS.
	 */
	public void bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		for(int i=1; i<=marca.length; i++) {
			if(!marca[i]) {
				this.bfs(i, grafo, marca);
			}
		}
	}
	
	private void bfs(int i, Grafo<T> grafo, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while(!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			System.out.println(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
	}
	
	/*
	 * BFS que devuelve una lista con los elementos visitados.
	 */
	public ListaGenerica<Vertice<T>> bfsLista(Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		for(int i=1; i<=marca.length; i++) {
			if(!marca[i]) {
				this.bfsLista(i, grafo, lis, marca);
			}
		}
		return lis;
	}
	
	private void bfsLista(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> lis, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while(!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			lis.agregarFinal(v);
			System.out.println(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
	}
	
	/*
	 * BFS que resuelve tiempo de infeccion de una red. (Cuenta niveles).
	 */
	public int calcularTiempoInfeccion(Grafo<String> g, Vertice<String> inicial) {
		int tiempo = 0;
		boolean visitados[] = new boolean[g.listaDeVertices().tamanio()+1];
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
		visitados[inicial.getPosicion()] = true;
		cola.encolar(inicial);
		cola.encolar(null);
		while(!cola.esVacia()) {
			Vertice<String> v = cola.desencolar();
			if(v != null) {
				ListaGenerica<Arista<String>> adyacentes = g.listaDeAdyacentes(v);
				adyacentes.comenzar();
				while(!adyacentes.fin()) {
					Arista<String> a = adyacentes.proximo();
					Vertice<String> w = a.verticeDestino();
					if(!visitados[w.getPosicion()]) {
						visitados[w.getPosicion()] = true;
						cola.encolar(w);
					}
				}
			} else if (!cola.esVacia()) {
				tiempo++;
				cola.encolar(null);
			}
		}
		return tiempo;
	}
}
