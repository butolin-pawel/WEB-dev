package com.example.lab4.repository;

import com.example.lab4.Entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car,Long> {
    List<Car> findAll();
}
