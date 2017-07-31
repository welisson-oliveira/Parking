package br.com.welisson.parking.domain.restapi.deserializer;

import br.com.welisson.parking.domain.restapi.wrapper.VacancyWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * {@link VacancyDeserializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/07/2017
 */
public class VacancyDeserializer extends JsonDeserializer<VacancyWrapper> {

	@Override
	public VacancyWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		return new VacancyWrapper(node.get("number").asInt());

	}
}
