package ej03B;

public class Profesor {
	private String nombre;
	private String apellido;
	private String email;
	private String catedra;
	private String facultad;
	
	public String tusDatos() {
		String a = getNombre() + getApellido() + getEmail() + getCatedra() + getFacultad();
		return a;
	}
	
	public void setNombre(String unNombre) {
		nombre = unNombre;
	}
	public void setApellido(String unApellido) {
		apellido = unApellido;
	}
	public void setEmail(String unEmail) {
		email = unEmail;
	}
	public void setCatedra(String unaCatedra) {
		catedra = unaCatedra;
	}
	public void setFacultad(String unaFacultad) {
		facultad = unaFacultad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public String getCatedra() {
		return catedra;
	}
	public String getFacultad() {
		return facultad;
	}
}
