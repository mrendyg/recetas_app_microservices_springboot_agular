package com.agarcia.microservice_cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.agarcia.commons_ingredients.persistence.models",
"com.agarcia.microservice_cookbook.persistence.models"})
public class MicroserviceCookbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCookbookApplication.class, args);
	}

}
