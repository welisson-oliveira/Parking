package br.com.welisson.parking.domain.parking.calculatorStrategy;

import br.com.welisson.parking.domain.parking.calculatorChainOfResponsability.Calculate;
import br.com.welisson.parking.domain.parking.events.EventRelease;

import java.math.BigDecimal;


/**
 * {@link CarCalculatorStrategy}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
public class CarCalculatorStrategy extends CalculatorStrategy {

	private final BigDecimal pricePerHour = new BigDecimal(10.0);

	public BigDecimal calculateParking(EventRelease eventRelease) {
		return new Calculate(calculateDuration(eventRelease.getTime()),pricePerHour).calculate();

	}

}
