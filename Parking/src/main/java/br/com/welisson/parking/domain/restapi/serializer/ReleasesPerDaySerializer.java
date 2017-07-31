package br.com.welisson.parking.domain.restapi.serializer;

import br.com.welisson.parking.domain.parking.events.EventRelease;
import br.com.welisson.parking.domain.restapi.wrapper.ReleasesPerDayWrapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;

import java.io.IOException;

/**
 * {@link ReleasesPerDaySerializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/07/2017
 */
@AllArgsConstructor
public class ReleasesPerDaySerializer extends JsonSerializer<ReleasesPerDayWrapper> {

	@Override
	public void serialize(ReleasesPerDayWrapper releasesPerDayWrapper, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

		jsonGenerator.writeStartArray();

		for(final EventRelease eventRelease : releasesPerDayWrapper.getEventRelease()){
			jsonGenerator.writeStartObject();
			jsonGenerator.writeNumberField("vacancyNumber",eventRelease.getVacancy().getNumber());
			jsonGenerator.writeStringField("vehiclePlaque",eventRelease.getVehicle().getPlaque());
			jsonGenerator.writeObjectField("time",eventRelease.getTime());
			jsonGenerator.writeNumberField("total",eventRelease.getTotal());
			jsonGenerator.writeObjectField("type",eventRelease.getType());
			jsonGenerator.writeEndObject();
		}

		jsonGenerator.writeEndArray();

	}
}
