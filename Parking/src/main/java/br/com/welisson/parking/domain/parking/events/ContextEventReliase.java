package br.com.welisson.parking.domain.parking.events;

import br.com.welisson.parking.domain.parking.Vacancy;
import br.com.welisson.parking.domain.parking.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * {@link ContextEventReliase}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
@AllArgsConstructor
@Getter
public class ContextEventReliase {

	private final Vacancy vacancy;
	private final Vehicle vehicle;
	private final Date time;
	private final BigDecimal total;
	private final ReleaseType type;

}
