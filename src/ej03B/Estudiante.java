package ej03B;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String comision;
	private String email;
	private String direccion;
	
	public Estudiante() {		
	}
	
	public Estudiante(String unNombre, String unApellido, String unaComision, String unEmail, String unaDireccion) {
		this.setNombre(unNombre);
		this.setApellido(unApellido);
		this.setComision(unaComision);
		this.setEmail(unEmail);
		this.setDireccion(unaDireccion);
	}
	
	public String tusDatos() {
		String a = "Nombre: " + getNombre() + " Apellido: " + getApellido() + " Comision: " + getComision() + " Email: " + getEmail() + " Direccion: " + getDireccion();
		return a;
	}
	
	public void setNombre(String unNombre) {
		nombre = unNombre;
	}
	public void setApellido(String unApellido) {
		apellido = unApellido;
	}
	public void setComision(String unaComision) {
		comision = unaComision;
	}
	public void setEmail(String unEmail) {
		email = unEmail;
	}
	public void setDireccion(String unaDireccion) {
		direccion = unaDireccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getComision() {
		return comision;
	}
	public String getEmail() {
		return email;
	}
	public String getDireccion() {
		return direccion;
	}
}
