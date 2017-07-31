package br.com.welisson.parking.parking;

import br.com.welisson.parking.config.SpringContextTestConfiguration;
import br.com.welisson.parking.config.TestContextInitializer;
import br.com.welisson.parking.config.WebConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * {@link ParkingControllerTest}
 *
 * @author Welisson Oliveira
 * @version 1.0 10/07/2017
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringContextTestConfiguration.class, WebConfig.class}, initializers = TestContextInitializer.class)
public class ParkingControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	public ParkingControllerTest(){}

	@Test
	public void launchEntryTest() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void launchExitTest(){

	}

	@Test
	public void getCoustTest(){

	}
	@Test
	public void eventReleasesBetweenTest(){

	}

	@Test
	public void newVacanceTest(){

	}

	@Test
	public void thereIsAvailableVacancyTest(){

	}

	@Test
	public void vacancies(){

	}


	private ResultActions performRESTPost(final String restURL, final String json) throws Exception {
		mockMvc = webAppContextSetup(context).build();
		return mockMvc.perform(
				MockMvcRequestBuilders.post(restURL).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json));
	}

	private ResultActions performRESTGet(final String restURL, final WebApplicationContext context)
			throws UnsupportedEncodingException, Exception {
		mockMvc = webAppContextSetup(context).build();
		return mockMvc.perform(get(restURL));
	}
}
