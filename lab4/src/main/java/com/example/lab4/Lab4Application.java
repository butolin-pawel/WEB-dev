package com.example.lab4;

import com.example.lab4.repository.BoxRepository;
import com.example.lab4.repository.CarRepository;
import com.example.lab4.repository.Car_washesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class Lab4Application {
	@Autowired
	public Lab4Application(Car_washesRepository car_washesRepository,BoxRepository boxRepository,CarRepository carRepository) {
		this.car_washesRepository = car_washesRepository;
		this.boxRepository = boxRepository;
		this.carRepository = carRepository;


	}
	public BoxRepository boxRepository;
	public CarRepository carRepository;

	public Car_washesRepository car_washesRepository;
	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

}
