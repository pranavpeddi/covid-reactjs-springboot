package com.Pranav.Backend;

import com.Pranav.Backend.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BackendApplication {



	public static void main(String[] args){

		SpringApplication.run(BackendApplication.class, args);

	}

}
