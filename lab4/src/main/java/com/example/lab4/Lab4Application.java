package com.example.lab4;

import com.example.lab4.repository.BoxRepository;
import com.example.lab4.repository.CarRepository;
import com.example.lab4.repository.Car_washesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab4Application {
@Autowired
	private BoxRepository boxRepository;
@Autowired
private CarRepository carRepository;
@Autowired
private Car_washesRepository car_washesRepository;
	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

}
