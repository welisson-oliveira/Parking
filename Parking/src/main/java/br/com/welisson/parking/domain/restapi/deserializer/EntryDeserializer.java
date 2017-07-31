package br.com.welisson.parking.domain.restapi.deserializer;

import br.com.welisson.parking.domain.parking.Car;
import br.com.welisson.parking.domain.parking.Motorcycle;
import br.com.welisson.parking.domain.parking.Parking;
import br.com.welisson.parking.domain.parking.Vacancy;
import br.com.welisson.parking.domain.parking.Vehicle;
import br.com.welisson.parking.domain.parking.VehicleType;
import br.com.welisson.parking.domain.restapi.wrapper.EntryWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link EntryDeserializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 07/07/2017
 */

public class EntryDeserializer extends JsonDeserializer<EntryWrapper> {
	@Autowired
	private Parking parking;
	private Vacancy vacancy;
	private Vehicle vehicle;

	@Override
	public EntryWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		vacancy = parking.getVacancy(node.get("vacancy").get("number").asInt());

		vehicle = strategyVehicle(node.get("vehicle").get("plaque").asText(),node.get("vehicle").get("brand").asText(),node.get("vehicle").get("color").asText()).get(node.get("vehicle").get("type").asText());

		return new EntryWrapper(vacancy, vehicle);
	}

	private Map<String, Vehicle > strategyVehicle(String s1, String s2, String s3) {

		final Map<String, Vehicle> strategy = new LinkedHashMap<>();
		strategy.put(VehicleType.CAR.toString(), new Car(s1, s2, s3));
		strategy.put(VehicleType.MOTORCYCLE.toString(), new Motorcycle(s1, s2, s3));

		return strategy;

	}
}
