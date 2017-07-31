package br.com.welisson.parking.domain.parking.calculatorChainOfResponsability;

import java.math.BigDecimal;

/**
 * {@link ThirtyMinutesCalculator}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/07/2017
 */
public class ThirtyMinutesCalculator extends AbstractCalculator {

	private BigDecimal thirty = new BigDecimal(30);

	public ThirtyMinutesCalculator(BigDecimal time, BigDecimal pricePerHour ) {
		super(time, pricePerHour, new SixtyMinutesCalculator(time, pricePerHour));
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
		return time.compareTo(thirty) <= 0;
	}
}
