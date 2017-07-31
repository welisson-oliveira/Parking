package br.com.welisson.parking.domain.restapi;

import br.com.welisson.parking.domain.parking.Parking;
import br.com.welisson.parking.domain.parking.Vacancy;
import br.com.welisson.parking.domain.parking.events.ReleaseType;
import br.com.welisson.parking.domain.restapi.wrapper.EntryWrapper;
import br.com.welisson.parking.domain.restapi.wrapper.ExitWrapper;
import br.com.welisson.parking.domain.restapi.wrapper.ReleasesPerDayWrapper;
import br.com.welisson.parking.domain.restapi.wrapper.VacancyWrapper;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * {@link ParkingController}
 *
 * @author Welisson Oliveira
 * @version 1.0 06/07/2017
 */
@RestController
@RequestMapping(value = "/parking")
@AllArgsConstructor
public class ParkingController {

	private final Parking parking;

	@GetMapping
	public String init() {
		return "Hello World";
	}

	@PostMapping(value = "/entry")
	@ResponseStatus(HttpStatus.CREATED)

	public void launchEntry(@RequestBody final EntryWrapper entryWrapper) throws Exception {
		parking.launchEntry(entryWrapper.getVacancy(), entryWrapper.getVehicle());
	}

	@PostMapping(value = "/exit")
	@ResponseStatus(HttpStatus.CREATED)
	public BigDecimal launchExit(@RequestBody final ExitWrapper exitWrapper) throws Exception {
		return parking.launchExit(exitWrapper.getEventRelease());
	}

	@GetMapping(value = "/cost/{plaque}")
	@ResponseStatus(HttpStatus.OK)
	public BigDecimal getCost(@PathVariable("plaque") final String plaque) throws IllegalStateException {
		return parking.getCost(plaque);
	}

	@GetMapping(value = "/releases/{initialDate}/{finalDate}")
	@ResponseStatus(HttpStatus.OK)
	public ReleasesPerDayWrapper eventReleasesBetween(
			@PathVariable("initialDate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date initialDate,
			@PathVariable("finalDate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date finalDate) {
		return new ReleasesPerDayWrapper(parking.eventReleasesBetween(initialDate, finalDate, ReleaseType.EXIT));
	}

	@PostMapping(value = "/vacancy")
	@ResponseStatus(HttpStatus.CREATED)
	public void newVacance(@RequestBody final VacancyWrapper vacancyWrapper) throws Exception {
		parking.newVacance(vacancyWrapper.getVacancy().getNumber());
	}

	@GetMapping(value = "/thereIsAvailableVacancy")
	@ResponseStatus(HttpStatus.OK)
	public Boolean thereIsAvailableVacancy() {
		return parking.thereIsAvailableVacancy();
	}

	@GetMapping(value = "/vacancies/{available}")
	@ResponseStatus(HttpStatus.OK)
	public List<Vacancy> vacancies(@PathVariable("available") final Boolean available) {
		return parking.vacancies(available);
	}

}
