package clases;

public class MissDistance {
	private float kilometers;

	public MissDistance(float kilometers) {
		super();
		this.kilometers = kilometers;
	}

	public float getKilometers() {
		return kilometers;
	}

	public void setKilometers(float kilometers) {
		this.kilometers = kilometers;
	}

	@Override
	public String toString() {
		return "Miss Distance : "+ kilometers;
	}
	

}
