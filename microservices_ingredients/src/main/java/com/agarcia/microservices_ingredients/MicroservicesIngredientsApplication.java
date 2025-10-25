package com.agarcia.microservices_ingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicesIngredientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesIngredientsApplication.class, args);
	}

}
 