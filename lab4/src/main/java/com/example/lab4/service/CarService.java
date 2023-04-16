package com.example.lab4.service;

import com.example.lab4.Entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    void saveCar(Car car);
    void deleteCarById(Long id);
    Car getCarById(Long id);
    void editCar(Car car);
}
