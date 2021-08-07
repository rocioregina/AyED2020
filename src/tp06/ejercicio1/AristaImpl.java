package tp06.ejercicio1;

public class AristaImpl<T> implements Arista<T>{
	private Vertice<T> destino;
	private int peso;
	
	public AristaImpl(Vertice<T> dest, int p){
		destino = dest;
		peso = p;
	}
	
	public Vertice<T> verticeDestino(){
		return this.destino;
	}
	
	public int peso() {
		return this.peso;
	}
}
