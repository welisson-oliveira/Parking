package br.com.welisson.parking.domain.restapi.wrapper;

import br.com.welisson.parking.domain.parking.events.EventRelease;
import br.com.welisson.parking.domain.restapi.deserializer.ExitDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * {@link ExitWrapper}
 *
 * @author Welisson Oliveira
 * @version 1.0 07/07/2017
 */
@JsonDeserialize(using = ExitDeserializer.class)
@Getter
public class ExitWrapper {

	private final EventRelease eventRelease;

	public ExitWrapper(EventRelease eventRelease) {
		this.eventRelease = eventRelease;
	}

}
