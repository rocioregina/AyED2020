package tp02.ej01;
import java.util.Scanner;

import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {
	public static void imprimir(ListaDeEnterosEnlazada l) {
		l.comenzar();
		if(!l.esVacia()) {
			for(int i=1; i<=l.tamanio(); i++) {
				System.out.println(l.elemento(i));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int aux;
		ListaDeEnterosEnlazada lis = new ListaDeEnterosEnlazada();
		System.out.println("Ingrese 5 numeros enteros: ");
		for(int i=0; i<=4; i++) {
			aux = scan.nextInt();
			lis.agregarFinal(aux);
		}
		scan.close();
		imprimir(lis);
	}
}
