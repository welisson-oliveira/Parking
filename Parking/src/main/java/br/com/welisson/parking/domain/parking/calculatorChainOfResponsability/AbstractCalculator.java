package br.com.welisson.parking.domain.parking.calculatorChainOfResponsability;

import java.math.BigDecimal;

/**
 * {@link AbstractCalculator}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/07/2017
 */
public abstract class AbstractCalculator {

	protected BigDecimal time;
	protected AbstractCalculator next;
	protected BigDecimal pricePerHour;

	public AbstractCalculator(BigDecimal time, BigDecimal pricePerHour,
			AbstractCalculator next) {
		this.time = time;
		this.next = next;
		this.pricePerHour = pricePerHour;
	}

	abstract protected boolean shouldCalculate();

	abstract public BigDecimal calculate();

}
