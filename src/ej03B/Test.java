package ej03B;

public class Test {
	public static void main(String[] args) {
		Estudiante[] eArray = new Estudiante[2];
		for(int i = 0; i<= eArray.length-1; i++) {
			eArray[i] = new Estudiante();
		}
		Profesor[] pArray = new Profesor[3];
		for(int i = 0; i<= pArray.length-1; i++) {
			pArray[i] = new Profesor();
		}
		for(int i = 0; i<= eArray.length-1; i++) {
			eArray[i].setNombre("Pedro");
			eArray[i].setApellido("Jimenez");
			eArray[i].setComision("1B");
			eArray[i].setEmail("pedro@gmail.com");
			eArray[i].setDireccion("Quintana 230");
		}
		for(int i = 0; i<= pArray.length-1; i++) {
			pArray[i].setNombre("Miguel");
			pArray[i].setApellido("Perez");
			pArray[i].setEmail("mperez@gmail.com");
			pArray[i].setCatedra("FOD");
			pArray[i].setFacultad("Informatica");
		}
		for(int i = 0; i<= eArray.length-1; i++) {
			System.out.print(eArray[i].tusDatos());
		}
		for(int i = 0; i<= pArray.length-1; i++) {
			System.out.print(pArray[i].tusDatos());
		}
	}
}
