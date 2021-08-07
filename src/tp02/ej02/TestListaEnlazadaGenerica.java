package tp02.ej02;
import tp02.ejercicio2.*;
import ej03B.*;

public class TestListaEnlazadaGenerica {
	
	public static void main(String[] args) {
		ListaEnlazadaGenerica<Estudiante> lis = new ListaEnlazadaGenerica<Estudiante>();
		lis.agregarFinal(new Estudiante("Pablo", "Gutierrez", "3", "pablogut@hotmail.com", "Quintana 908"));
		lis.agregarInicio(new Estudiante("Ludmila", "Soto", "2", "ludst@gmail.com", "15 3560"));
		lis.agregarEn(new Estudiante("Esteban", "Quiroga", "2", "estuquiroga@outlook.com", "4 bis 272"), 2);
		lis.agregarFinal(new Estudiante("Luciano", "Barrios", "1", "lubarrios98@hotmail.com", "480 2351"));
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo().tusDatos());
		}
	}	
}
