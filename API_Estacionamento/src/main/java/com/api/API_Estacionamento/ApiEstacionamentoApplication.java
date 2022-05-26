package com.api.API_Estacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiEstacionamentoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ApiEstacionamentoApplication.class, args);
	
	}
	
	@GetMapping("/")
	public String indes() {
		return "Hello World";
	}

}
