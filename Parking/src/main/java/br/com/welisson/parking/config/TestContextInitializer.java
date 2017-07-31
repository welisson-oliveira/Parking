package br.com.welisson.parking.config;


import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link TestContextInitializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 10/07/2017
 */
public class TestContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
		configurableApplicationContext.getEnvironment().setActiveProfiles("local");
	}
}
