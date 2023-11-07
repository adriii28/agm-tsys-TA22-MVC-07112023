package Model;

public class ProyectoAsignado {

	private String nombreCientifico;
	private String dniCientifico;
	private String idProyecto;
	private String nombreProyecto;
	
	public ProyectoAsignado() {
	
	}

	public ProyectoAsignado(String nombreCientifico, String dniCientifico, String idProyecto, String nombreProyecto) {
		this.nombreCientifico = nombreCientifico;
		this.dniCientifico = dniCientifico;
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getDniCientifico() {
		return dniCientifico;
	}

	public void setDniCientifico(String dniCientifico) {
		this.dniCientifico = dniCientifico;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	@Override
	public String toString() {
		return "Nombre Cientifico: " + nombreCientifico + ",  DNI: " + dniCientifico+ " | ID Proyecto Asignado" + idProyecto + " | Nombre Proyecto: " + nombreProyecto;
	}
	
	
	
	
	
}
