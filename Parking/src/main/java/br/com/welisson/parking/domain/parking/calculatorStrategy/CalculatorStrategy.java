package br.com.welisson.parking.domain.parking.calculatorStrategy;

import br.com.welisson.parking.domain.parking.events.EventRelease;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.math.BigDecimal;
import java.util.Date;

/**
 * {@link CalculatorStrategy}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
public abstract class CalculatorStrategy {

	protected BigDecimal calculateDuration(Date date){
		DateTime entryDate = new DateTime(date.getTime());
		DateTime exitDate = new DateTime();

		return new BigDecimal(new Duration(entryDate, exitDate).getStandardMinutes());
	}

	public abstract BigDecimal calculateParking(EventRelease eventRelease);

	/*public BigDecimal calculateParking(EventRelease eventRelease, BigDecimal pricePerHour) {
		DateTime entryDate = new DateTime(eventRelease.getTime());
		DateTime exitDate = new DateTime();

		Duration duration = new Duration(entryDate, exitDate);

		BigDecimal totalInSeconds = new BigDecimal(duration.getStandardMinutes());
		if(totalInSeconds.compareTo(fifteen) <= 0){
			return new BigDecimal(0);
		} else if(totalInSeconds.compareTo(thirty) <= 0){
			return pricePerHour.divide(new BigDecimal(2));
		} else if(totalInSeconds.compareTo(sixty) <= 0){
			return pricePerHour;
		} else{
			Integer totHours = new Integer(0);
			while(totalInSeconds.compareTo(new BigDecimal(0)) > 0){
				totHours = Integer.sum(totHours, new Integer(1));
				totalInSeconds = totalInSeconds.subtract(sixty);
			}
			if(totalInSeconds.compareTo(new BigDecimal(0)) > 0){
				totHours = Integer.sum(totHours, new Integer(1));
			}
			return new BigDecimal(totHours).multiply(pricePerHour);
		}
	}*/

}
