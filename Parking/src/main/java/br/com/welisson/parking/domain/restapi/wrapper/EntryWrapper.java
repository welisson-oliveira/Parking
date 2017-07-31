package br.com.welisson.parking.domain.restapi.wrapper;

import br.com.welisson.parking.domain.parking.Vacancy;
import br.com.welisson.parking.domain.parking.Vehicle;
import br.com.welisson.parking.domain.restapi.deserializer.EntryDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link EntryWrapper}
 *
 * @author Welisson Oliveira
 * @version 1.0 07/07/2017
 */
@JsonDeserialize(using = EntryDeserializer.class)
@Getter
@AllArgsConstructor
public class EntryWrapper {

	private final Vacancy vacancy;
	private final Vehicle vehicle;

}
