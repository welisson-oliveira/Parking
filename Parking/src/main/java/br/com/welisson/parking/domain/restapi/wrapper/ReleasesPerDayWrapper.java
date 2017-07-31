package br.com.welisson.parking.domain.restapi.wrapper;

import br.com.welisson.parking.domain.parking.events.EventRelease;
import br.com.welisson.parking.domain.restapi.serializer.ReleasesPerDaySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * {@link ReleasesPerDayWrapper}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/07/2017
 */

@JsonSerialize(using = ReleasesPerDaySerializer.class)
@AllArgsConstructor
public class ReleasesPerDayWrapper {

	private List<EventRelease> eventReleaseList;

	public List<EventRelease> getEventRelease(){
		return Collections.unmodifiableList(this.eventReleaseList);
	}


}
