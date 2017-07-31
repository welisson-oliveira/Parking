package br.com.welisson.parking.domain.parking.calculatorChainOfResponsability;

import java.math.BigDecimal;

/**
 * {@link SixtyMinutesCalculator}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/07/2017
 */
public class SixtyMinutesCalculator extends AbstractCalculator {

	private BigDecimal sixty = new BigDecimal(60);

	public SixtyMinutesCalculator(BigDecimal time, BigDecimal pricePerHour ) {
		super(time, pricePerHour, new SixtyOrMoreCalculator(time, pricePerHour));
	}

	@Override
	public BigDecimal calculate() {
		if(shouldCalculate()) {
			return pricePerHour.divide(new BigDecimal(2));
		}
		return next.calculate();
	}

	@Override
	protected boolean shouldCalculate() {
		return time.compareTo(sixty) <= 0;
	}
}
