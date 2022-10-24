package pruebas.binding;

public class Casa {
	private String nombre;
	private short añoFundacion;
	private String ciudadOrigen;
	
	public Casa(String nombre, short añoFundacion, String ciudadOrigen) {
		super();
		this.nombre = nombre;
		this.añoFundacion = añoFundacion;
		this.ciudadOrigen = ciudadOrigen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public short getAñoFundacion() {
		return añoFundacion;
	}

	public void setAñoFundacion(short añoFundacion) {
		this.añoFundacion = añoFundacion;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	
	
}
