package br.com.welisson.parking.domain.parking.calculatorStrategy;

import br.com.welisson.parking.domain.parking.events.EventRelease;

import java.math.BigDecimal;

/**
 * {@link TruckCalculatorStrategy}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/07/2017
 */
public class TruckCalculatorStrategy extends CalculatorStrategy {

	@Override
	public BigDecimal calculateParking(EventRelease eventRelease) {
		//caso o calculo não for igual da super classe, implemente aqui.
		return null;
	}
}
