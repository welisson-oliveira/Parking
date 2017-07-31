package br.com.welisson.parking.domain.parking;

import br.com.welisson.parking.domain.parking.calculatorStrategy.CalculatorStrategy;
import br.com.welisson.parking.domain.parking.calculatorStrategy.CarCalculatorStrategy;
import br.com.welisson.parking.domain.parking.calculatorStrategy.MotorcycleCalculatorStrategy;
import br.com.welisson.parking.domain.parking.events.EventRelease;
import br.com.welisson.parking.domain.parking.events.ReleaseType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@link Parking}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
@Component
public class Parking {

	private List<Vacancy> vacancies;
	private final List<EventRelease> eventReliases;
	private final Map<Class<?>, CalculatorStrategy> strategyMap = new HashMap<>();

	public Parking() {
		vacancies = new ArrayList<>();
		eventReliases = new ArrayList<>();
		strategyMap.putAll(strategyCalculator());

		Collections.addAll(vacancies, new Vacancy[] { new Vacancy(1), new Vacancy(2), new Vacancy(3) });
	}

	public void launchEntry(final Vacancy vacancy, final Vehicle vehicle) throws Exception {

		final ReleaseType type = ReleaseType.ENTRY;
		if(!thereIsAvailableVacancy()){
			throw new Exception("Não há mais vagas");
		}

		if(!vacancy.isBusy()) {
			vacancy.park(vehicle);
			eventReliases.add(new EventRelease(vacancy, vehicle, type, createDate()));
		}else{
			throw new Exception("Vaga já ocupada");
		}

	}

	public BigDecimal getCost(String plaque) throws IllegalStateException {

		final EventRelease eventRelease = getEventReleaseByPlaque(plaque);

		final CalculatorStrategy calculatorStrategy = strategyMap.get(eventRelease.getVehicle().getClass());

		return calculatorStrategy.calculateParking(eventRelease);

	}

	public BigDecimal getCost(EventRelease eventRelease){

		final CalculatorStrategy calculatorStrategy = strategyMap.get(eventRelease.getVehicle().getClass());

		return calculatorStrategy.calculateParking(eventRelease);

	}

	public BigDecimal launchExit(EventRelease entry) throws Exception {

		final ReleaseType type = ReleaseType.EXIT;

		if(entry == null){
			throw new Exception("Sistema não possui lançamento de entrada ativa para esse veiculo!");
		}

		Vacancy vacancy = entry.getVacancy();
		vacancy.vacate();

		BigDecimal coust = getCost(entry);

		eventReliases.add(new EventRelease(vacancy, entry.getVehicle(), coust,type));
		return coust;
	}

	public List<EventRelease> eventReleasesBetween(Date initalDate, Date finalDate, ReleaseType releaseType){
		List<EventRelease> er = eventReliases.stream().filter(eventRelease -> eventRelease.getTime().getTime() >= initalDate.getTime() && eventRelease.getTime().getTime() <= finalDate.getTime() && eventRelease.getType() == releaseType).collect(Collectors.toList());
		return er;
	}

	private Map<Class<?>, CalculatorStrategy> strategyCalculator() {

		final Map<Class<?>, CalculatorStrategy> strategy = new LinkedHashMap<>();
		strategy.put(Car.class, new CarCalculatorStrategy());
		strategy.put(Motorcycle.class, new MotorcycleCalculatorStrategy());

		return strategy;

	}

	public void newVacance(Integer number) throws Exception {
		if(vacancies.stream().filter(vacancy -> vacancy.getNumber().equals(number)).findAny().isPresent()){
			throw new Exception("Já existe uma vaga com esse numero");
		}
		vacancies.add(new Vacancy(number));
	}

	public Boolean thereIsAvailableVacancy(){
		return availableVacancies().size() > 0;
	}

	public List<Vacancy> vacancies(Boolean available){
		return available ? availableVacancies() : vacanciesNotOccupied();
	}

	private List<Vacancy> availableVacancies(){
		return Collections.unmodifiableList(vacancies.stream().filter(vacancy -> !vacancy.isBusy()).collect(Collectors.toList()));
	}

	private List<Vacancy> vacanciesNotOccupied(){
		return Collections.unmodifiableList(vacancies.stream().filter(vacancy -> vacancy.isBusy()).collect(Collectors.toList()));
	}

	public Vacancy getVacancy(Integer number){
		return vacancies.stream().filter(vacancy -> vacancy.getNumber().equals(number)).findAny().orElseThrow(IllegalStateException::new);
	}

	public EventRelease getEventReleaseByPlaque(String plaque) throws IllegalStateException {
		return eventReliases.stream().filter(eventRelease -> eventRelease.getVehicle().getPlaque().equals(plaque) && eventRelease.getVacancy().isBusy() && eventRelease.getType() == ReleaseType.ENTRY).findFirst().orElseThrow(IllegalStateException::new);
	}

	public Date createDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			return sdf.parse("14/07/2017 14:30:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}



















