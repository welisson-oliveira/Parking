package br.com.welisson.parking.domain.parking.calculatorChainOfResponsability;

import java.math.BigDecimal;

/**
 * {@link FifteenMinutesCalculator}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/07/2017
 */
public class FifteenMinutesCalculator extends AbstractCalculator {

	private BigDecimal fifteen = new BigDecimal(15);

	public FifteenMinutesCalculator(BigDecimal time, BigDecimal pricePerHour) {
		super(time, pricePerHour, new ThirtyMinutesCalculator(time, pricePerHour));
	}

	@Override
	public BigDecimal calculate() {
		if (shouldCalculate()) {
			return new BigDecimal(0);
		}
		return next.calculate();
	}

	@Override
	protected boolean shouldCalculate() {
		return time.compareTo(fifteen) <= 0;

	}
}
