package br.com.welisson.parking.domain.parking.events;

import br.com.welisson.parking.domain.parking.Vacancy;
import br.com.welisson.parking.domain.parking.Vehicle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.EventObject;

/**
 * {@link EventRelease}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
public class EventRelease extends EventObject {

	public EventRelease(Vacancy vacancy, Vehicle vehicle, ReleaseType type, Date temp) {

		super(new ContextEventReliase(vacancy, vehicle, temp, new BigDecimal("0"), type));
	}

	public EventRelease(Vacancy vacancy, Vehicle vehicle, BigDecimal total, ReleaseType type) {
		super(new ContextEventReliase(vacancy, vehicle, new Date(), total, type));
	}

	public Vacancy getVacancy() {
		return getSource().getVacancy();
	}

	public Vehicle getVehicle() {
		return getSource().getVehicle();
	}

	public Date getTime() {
		return getSource().getTime();
	}

	public ReleaseType getType() {
		return getSource().getType();
	}

	public BigDecimal getTotal() {
		return getSource().getTotal();
	}

	@Override
	public ContextEventReliase getSource() {
		return (ContextEventReliase) super.getSource();
	}

}
