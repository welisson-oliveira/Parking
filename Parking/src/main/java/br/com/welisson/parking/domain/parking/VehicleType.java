package br.com.welisson.parking.domain.parking;

/**
 * {@link VehicleType}
 *
 * @author Welisson Oliveira
 * @version 1.0 07/07/2017
 */
public enum VehicleType {
	CAR("Car"), MOTORCYCLE("Motorcycle");

	private final String value;

	VehicleType(String value) {
		this.value = value;
	}

	public String toString(){
		return this.value;
	}
}
