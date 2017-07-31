package br.com.welisson.parking.domain.restapi.deserializer;

import br.com.welisson.parking.domain.parking.Parking;
import br.com.welisson.parking.domain.parking.events.EventRelease;
import br.com.welisson.parking.domain.restapi.wrapper.ExitWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;

import java.io.IOException;

/**
 * {@link ExitDeserializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 07/07/2017
 */
@AllArgsConstructor
public class ExitDeserializer extends JsonDeserializer<ExitWrapper> {

	private Parking parking;

	@Override
	public ExitWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		EventRelease eventRelease = null;
		try {
			eventRelease = parking.getEventReleaseByPlaque(node.get("plaque").asText());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ExitWrapper(eventRelease);
	}

}
