package br.com.welisson.parking.domain.restapi.wrapper;

import br.com.welisson.parking.domain.parking.Vacancy;
import br.com.welisson.parking.domain.restapi.deserializer.VacancyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * {@link VacancyWrapper}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/07/2017
 */
@JsonDeserialize(using = VacancyDeserializer.class)
public class VacancyWrapper {

	private Vacancy vacancy;

	public VacancyWrapper(Integer number){
		this.vacancy = new Vacancy(number);
	}

	public Vacancy getVacancy(){
		return this.vacancy;
	}

}
