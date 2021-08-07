package tp02.ej01;
import tp02.ejercicio1.*;
import java.util.Scanner;

public class TestListaDeEnterosConArreglos {
	public static void imprimirInverso(ListaDeEnterosConArreglos l) {
		if(!l.fin()) {
			Integer actual = l.proximo();
			imprimirInverso(l);
		System.out.println(actual);
		}
	}
	
	public static void imprimir(ListaDeEnterosConArreglos l) {
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
		ListaDeEnterosConArreglos lis = new ListaDeEnterosConArreglos();
		System.out.println("Ingrese 5 numeros enteros: ");
		for(int i=0; i<=4; i++) {
			aux = scan.nextInt();
			lis.agregarFinal(aux);
		}
		scan.close();
		imprimir(lis);
		imprimirInverso(lis);
	}
}
