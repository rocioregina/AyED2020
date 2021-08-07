package tp06.ejercicio5;
import tp06.ejercicio1.*;
import tp02.ejercicio2.*;

public class MapaTest {

	    public static void main(String[] args) {
	        GrafoImplListAdy<String> grafodirigido = new GrafoImplListAdy<String>();
	        VerticeImplListAdy<String> vertdA = new VerticeImplListAdy<String>("A");
	        VerticeImplListAdy<String> vertdB = new VerticeImplListAdy<String>("B");
	        VerticeImplListAdy<String> vertdC = new VerticeImplListAdy<String>("C");
	        VerticeImplListAdy<String> vertdD = new VerticeImplListAdy<String>("D");
	        VerticeImplListAdy<String> vertdE = new VerticeImplListAdy<String>("E");
	        VerticeImplListAdy<String> vertdR = new VerticeImplListAdy<String>("R");
	        grafodirigido.agregarVertice(vertdA);
	        grafodirigido.agregarVertice(vertdB);
	        grafodirigido.agregarVertice(vertdC);
	        grafodirigido.agregarVertice(vertdD);
	        grafodirigido.agregarVertice(vertdE);
	        grafodirigido.agregarVertice(vertdR);
	        grafodirigido.conectar(vertdA, vertdB, 10);
	        grafodirigido.conectar(vertdB, vertdC, 30);
	        grafodirigido.conectar(vertdB, vertdR, 40);
	        grafodirigido.conectar(vertdC, vertdA, 20);
	        grafodirigido.conectar(vertdC, vertdD, 10);
	        grafodirigido.conectar(vertdD, vertdB, 10);
	        grafodirigido.conectar(vertdD, vertdR, 60);
	        grafodirigido.conectar(vertdE, vertdA, 10);
	        grafodirigido.conectar(vertdE, vertdC, 70);
	        
	        Mapa mapa = new Mapa(grafodirigido);
	        ListaEnlazadaGenerica<String> excepto = new ListaEnlazadaGenerica<String>();
	        excepto.agregarFinal("B");
	        ListaGenerica<String> resultadoString = mapa.devolverCamino("C", "R");
	        System.out.println(resultadoString);
	        if (resultadoString.esVacia()) {
	            System.out.println("vacia");
	        }
	    }
}
