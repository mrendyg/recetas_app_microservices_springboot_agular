package com.agarcia.microservices_ingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = {"com.agarcia.commons_ingredients.persistence.models"})
public class MicroservicesIngredientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesIngredientsApplication.class, args);
	}

}
 