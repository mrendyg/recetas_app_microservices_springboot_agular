package com.agarcia.sales_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SalesMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesApplication.class, args);
	}

}
