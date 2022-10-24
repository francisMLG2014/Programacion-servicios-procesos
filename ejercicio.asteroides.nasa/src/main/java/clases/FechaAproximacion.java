package clases;

import java.time.LocalDateTime;

public class FechaAproximacion {
	private String close_approach_date_full;
	private MissDistance miss_distance;
	
	
	public FechaAproximacion(String close_approach_date_full, MissDistance miss_distance) {
		super();
		this.close_approach_date_full = close_approach_date_full;
		this.miss_distance = miss_distance;
	}


	public String getClose_approach_date_full() {
		return close_approach_date_full;
	}


	public void setClose_approach_date_full(String close_approach_date_full) {
		this.close_approach_date_full = close_approach_date_full;
	}


	public MissDistance getMiss_distance() {
		return miss_distance;
	}


	public void setMiss_distance(MissDistance miss_distance) {
		this.miss_distance = miss_distance;
	}


	@Override
	public String toString() {
		return "FechaAproximacion: " + close_approach_date_full + " / "
				+ miss_distance;
	}

}
