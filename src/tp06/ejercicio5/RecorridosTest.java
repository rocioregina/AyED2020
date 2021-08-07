package tp06.ejercicio5;
import tp06.ejercicio1.*;

public class RecorridosTest {
	
	public static void main(String[] args) {
	Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
	Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
	Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
	
	Grafo<String> ciudades = new GrafoImplListAdy<String>();
	ciudades.agregarVertice(v1);
	ciudades.agregarVertice(v2);
	ciudades.agregarVertice(v3);
	
	ciudades.conectar(v1, v2);
	ciudades.conectar(v1, v3);
	
	Recorridos<String> r = new Recorridos<String>();
	System.out.println("--- Se imprime el grafo con DFS ---");
	r.dfs(ciudades);
	}
}
