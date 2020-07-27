package com.Pranav.Backend;

import com.Pranav.Backend.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {


	@Autowired
	private CovidDataService covidDataService;
	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		covidDataService.saveData();
	}
}
