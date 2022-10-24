package clases;

public class Kilometros {
	private float estimated_diameter_min;
	private float estimated_diameter_max;
	public Kilometros(float estimated_diameter_min, float estimated_diameter_max) {
		super();
		this.estimated_diameter_min = estimated_diameter_min;
		this.estimated_diameter_max = estimated_diameter_max;
	}
	public float getEstimated_diameter_min() {
		return estimated_diameter_min;
	}
	public void setEstimated_diameter_min(float estimated_diameter_min) {
		this.estimated_diameter_min = estimated_diameter_min;
	}
	public float getEstimated_diameter_max() {
		return estimated_diameter_max;
	}
	public void setEstimated_diameter_max(float estimated_diameter_max) {
		this.estimated_diameter_max = estimated_diameter_max;
	}
	@Override
	public String toString() {
		return "estimated_diameter_min = " + estimated_diameter_min + " / estimated_diameter_max = "
				+ estimated_diameter_max ;
	}
	
	

}
