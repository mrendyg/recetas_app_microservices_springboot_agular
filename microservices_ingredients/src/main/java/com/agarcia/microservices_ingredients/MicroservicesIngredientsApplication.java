package com.agarcia.microservices_ingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesIngredientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesIngredientsApplication.class, args);
	}

}
 