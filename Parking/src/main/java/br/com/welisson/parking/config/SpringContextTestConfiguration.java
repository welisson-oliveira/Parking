package br.com.welisson.parking.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * {@link SpringContextTestConfiguration}
 *
 * @author Welisson Oliveira
 * @version 1.0 10/07/2017
 */
@Configuration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ParkingApplication.class)
@ComponentScan(basePackages = "br.com.welisson.parking.*")
public class SpringContextTestConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Validator validator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}

}
