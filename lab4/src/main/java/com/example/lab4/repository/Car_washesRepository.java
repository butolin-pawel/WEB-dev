package com.example.lab4.repository;

import com.example.lab4.Entity.Carwashes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Car_washesRepository extends CrudRepository<Carwashes,Long> {
    List<Carwashes> findAll();

    List<Carwashes> findAllByActive(boolean active);
}
