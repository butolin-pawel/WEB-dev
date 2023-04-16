package com.example.lab4.service.impl;

import com.example.lab4.Entity.Car;
import com.example.lab4.repository.CarRepository;
import com.example.lab4.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        super();
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getCarById(Long id) {
       return carRepository.findById(id).get();
    }

    @Override
    public void editCar(Car car) {
        carRepository.save(car);
    }
}
