package clases;

public class Diametro {
	private Kilometros kilometers;

	public Diametro(Kilometros kilometers) {
		super();
		this.kilometers = kilometers;
	}

	public Kilometros getKilometers() {
		return kilometers;
	}

	public void setKilometers(Kilometros kilometers) {
		this.kilometers = kilometers;
	}

	@Override
	public String toString() {
		return ""+this.kilometers;
	}
	
}
