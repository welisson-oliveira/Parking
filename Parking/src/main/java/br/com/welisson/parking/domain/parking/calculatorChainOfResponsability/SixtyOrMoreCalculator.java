package br.com.welisson.parking.domain.parking.calculatorChainOfResponsability;

import java.math.BigDecimal;

/**
 * {@link SixtyOrMoreCalculator}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/07/2017
 */
public class SixtyOrMoreCalculator extends AbstractCalculator {

	private BigDecimal sixty = new BigDecimal(60);

	public SixtyOrMoreCalculator(BigDecimal time, BigDecimal pricePerHour ) {
		super(time, pricePerHour, null);
	}

	@Override
	public BigDecimal calculate() {
		if(shouldCalculate()) {
			Integer totHours = new Integer(0);
			while(time.compareTo(new BigDecimal(0)) > 0){
				totHours = Integer.sum(totHours, new Integer(1));
				time = time.subtract(sixty);
			}
			if(time.compareTo(new BigDecimal(0)) > 0){
				totHours = Integer.sum(totHours, new Integer(1));
			}
			return new BigDecimal(totHours).multiply(pricePerHour);
		}
		return next.calculate();
	}

	@Override
	protected boolean shouldCalculate() {
		return true;
	}
}
