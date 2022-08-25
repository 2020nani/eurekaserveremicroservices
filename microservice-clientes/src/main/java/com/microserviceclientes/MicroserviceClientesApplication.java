package com.microserviceclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientesApplication.class, args);
	}

}
