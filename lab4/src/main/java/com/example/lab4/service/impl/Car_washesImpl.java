package com.example.lab4.service.impl;

import com.example.lab4.Entity.Carwashes;
import com.example.lab4.repository.Car_washesRepository;
import com.example.lab4.service.Car_washesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Car_washesImpl implements Car_washesService {
    private final Car_washesRepository car_washesRepository;

    public Car_washesImpl(Car_washesRepository car_washesRepository) {
        super();
        this.car_washesRepository = car_washesRepository;
    }

    @Override
    public List<Carwashes> getAllWash() {
        return car_washesRepository.findAll();
    }

    @Override
    public void saveWash(Carwashes carwashes) {
            car_washesRepository.save(carwashes);
    }

    @Override
    public void deleteWashById(Long id) {
        car_washesRepository.deleteById(id);
    }

    @Override
    public Carwashes getWashById(Long id) {
        return car_washesRepository.findById(id).get();
    }

    @Override
    public void editWash(Carwashes carwashes) {
        car_washesRepository.save(carwashes);
    }
}
