package pruebas.binding;

public class Casa {
	private String nombre;
	private short a�oFundacion;
	private String ciudadOrigen;
	
	public Casa(String nombre, short a�oFundacion, String ciudadOrigen) {
		super();
		this.nombre = nombre;
		this.a�oFundacion = a�oFundacion;
		this.ciudadOrigen = ciudadOrigen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public short getA�oFundacion() {
		return a�oFundacion;
	}

	public void setA�oFundacion(short a�oFundacion) {
		this.a�oFundacion = a�oFundacion;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	
	
}
