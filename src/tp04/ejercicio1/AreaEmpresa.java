package tp04.ejercicio1;

public class AreaEmpresa {
	private String id;
	private Integer tardanza;
	
	public AreaEmpresa() {
		this.setID("");
		this.setTardanza(0);
	}
	
	public AreaEmpresa(Integer t) {
		this.setID("");
		this.setTardanza(t);
	}
	
	public void setID(String unID) {
		id = unID;
	}
	public String getID() {
		return id;
	}
	public void setTardanza(Integer unaTardanza) {
		tardanza = unaTardanza;
	}
	public Integer getTardanza() {
		return tardanza;
	}
}
