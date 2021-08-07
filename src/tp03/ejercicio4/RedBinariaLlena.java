package tp03.ejercicio4;
import ejercicio1.*;

public class RedBinariaLlena {
	private ArbolBinario<Integer> datos;
	
	public RedBinariaLlena(ArbolBinario<Integer> a) {
		datos = a;
	}
	
	private void retardoPreOrden(int cont, ArbolBinario<Integer> a, Maximo m) {
		if(!a.esVacio()) {
			cont = cont + a.getDatoRaiz();
		}
		if(a.esHoja()) {
			if(cont > m.getMax()) {
				m.setMax(cont);
			}
		}
		if(!a.getHijoIzquierdo().esVacio()) {
			this.retardoPreOrden(cont, a.getHijoIzquierdo(), m);
		}
		if(!a.getHijoDerecho().esVacio()) {
			this.retardoPreOrden(cont, a.getHijoDerecho(), m);
		}
	}
	
	public int retardoReenvio() {
		int contador = 0;
		Maximo m = new Maximo();
		this.retardoPreOrden(contador, this.datos, m);
		return m.getMax();
	}
}
