package br.com.welisson.parking.domain.parking.calculatorChainOfResponsability;

import java.math.BigDecimal;

/**
 * {@link Calculate}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/07/2017
 */
public class Calculate extends AbstractCalculator{

	public Calculate(BigDecimal time, BigDecimal pricePerHour) {
		super(time,pricePerHour, new FifteenMinutesCalculator(time, pricePerHour));
	}

	@Override public BigDecimal calculate() {
		return next.calculate();
	}

	@Override
	protected boolean shouldCalculate() {
		return next.shouldCalculate();
	}

}
