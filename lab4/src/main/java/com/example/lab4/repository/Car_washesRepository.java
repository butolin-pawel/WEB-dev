package com.example.lab4.repository;

import com.example.lab4.Entity.Carwashes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Car_washesRepository extends CrudRepository<Carwashes,Long> {
    List<Carwashes> findAll();
}
