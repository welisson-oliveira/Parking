package br.com.welisson.parking.domain.parking;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link Vehicle}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
@AllArgsConstructor
@Getter
public abstract class Vehicle {

	private String plaque;
	private String brand;
	private String color;


}
