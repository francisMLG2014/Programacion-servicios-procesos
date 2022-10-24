package pruebas.binding;

public class Coche {
	private String modelo;
	private String color;
	private byte nPuertas;
	private boolean matriculado;
	private short año;
	private Casa casa;
	
	public Coche(String modelo, String color, byte nPuertas, boolean matriculado, short año, Casa casa) {
		super();
		this.modelo = modelo;
		this.color = color;
		this.nPuertas = nPuertas;
		this.matriculado = matriculado;
		this.año = año;
		this.casa = casa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public byte getnPuertas() {
		return nPuertas;
	}

	public void setnPuertas(byte nPuertas) {
		this.nPuertas = nPuertas;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	public short getAño() {
		return año;
	}

	public void setAño(short año) {
		this.año = año;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
	
	public String toString() {
		return this.casa.getNombre()+" "+this.modelo+" "+this.color+" del "+this.año+"\n";
	}
}
