package br.com.welisson.parking.domain.parking;

import lombok.Getter;

/**
 * {@link Vacancy}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
@Getter
public class Vacancy {

	private final Integer number;
	private Boolean available;
	private Vehicle vehicle;

	public Vacancy(Integer number){
		this.number = number;
		this.available = true;
		this.vehicle = null;
	}

	public Boolean parkedHere(Vehicle vehicle) {
		if(!isBusy()){
			return false;
		}
		return this.vehicle.equals(vehicle);
	}

	public Boolean isBusy(){
		return !this.available;
	}

	public void park(Vehicle vehicle) throws Exception {
		if(isBusy()){
			throw new Exception("Ocupado");
		}
		this.available = false;
		this.vehicle = vehicle;
	}

	public void vacate(){
		this.vehicle = null;
		this.available = true;
	}


}
