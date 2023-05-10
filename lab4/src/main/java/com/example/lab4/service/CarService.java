package com.example.lab4.service;

import com.example.lab4.Entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {
    List<Car> getAllCars();
    void saveCar(Car car);
    void deleteCarById(Long id);
    Car getCarById(Long id);
    void editCar(Car car);
}
