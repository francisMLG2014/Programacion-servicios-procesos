package clases;

import java.util.ArrayList;

public class Asteroide implements Comparable{
	private String name;
	private Diametro stimated_diameter;
	private boolean is_potentially_hazardous_asteroid;
	private ArrayList<FechaAproximacion> close_approach_data;
	
	public Asteroide(String name, Diametro stimated_diameter, boolean is_potentially_hazardous_asteroid,
			ArrayList<FechaAproximacion> close_approach_data) {
		super();
		this.name = name;
		this.stimated_diameter = stimated_diameter;
		this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
		this.close_approach_data = close_approach_data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Diametro getStimated_diameter() {
		return stimated_diameter;
	}

	public void setStimated_diameter(Diametro stimated_diameter) {
		this.stimated_diameter = stimated_diameter;
	}

	public boolean isIs_potentially_hazardous_asteroid() {
		return is_potentially_hazardous_asteroid;
	}

	public void setIs_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
		this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
	}

	public ArrayList<FechaAproximacion> getClose_approach_data() {
		return close_approach_data;
	}

	public void setClose_approach_data(ArrayList<FechaAproximacion> close_approach_data) {
		this.close_approach_data = close_approach_data;
	}

	@Override
	public String toString() {
		return name + " / " + stimated_diameter
				+ " / Potencialmente peligroso: " + is_potentially_hazardous_asteroid + " / "
				+ close_approach_data;
	}

	public int compareTo(Object o) {
		Asteroide otro=(Asteroide)o;
		if(this.is_potentially_hazardous_asteroid==otro.is_potentially_hazardous_asteroid) {
			return this.compareTo(otro.compareTo(otro));
		}else {
			return (int) (this.stimated_diameter.getKilometers().getEstimated_diameter_max()-otro.stimated_diameter.getKilometers().getEstimated_diameter_max());
		}
	}
	
	
}
