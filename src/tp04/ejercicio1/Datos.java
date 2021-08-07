package tp04.ejercicio1;

public class Datos {
	private int a;
	private int b;
	
	public Datos() {
		a=0; b=0;
	}
	
	public String getDatos() {
		String exp = "Primer elemento par: " + this.getA() + ". Nivel: " + this.getB();
		return exp;
	}
	
	public void setA(int unA) {
		a = unA;
	}
	
	public int getA() {
		return a;
	}
	
	public void setB(int unB) {
		b = unB;
	}
	
	public int getB() {
		return b;
	}
}
