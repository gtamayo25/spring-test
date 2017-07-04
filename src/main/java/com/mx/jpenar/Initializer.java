package com.mx.jpenar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = MessageSourceAutoConfiguration.class)
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class Initializer extends SpringBootServletInitializer {
	private static final Logger LOG4J = LoggerFactory.getLogger(Initializer.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		LOG4J.info("Initializer configure: Initializing");

		System.setProperty("spring.profiles.active", "dev");
		System.setProperty("com.ibm.websphere.jaxrs.server.DisableIBMJAXRSEngine", "true");

		return application.sources(Initializer.class);
	}

}