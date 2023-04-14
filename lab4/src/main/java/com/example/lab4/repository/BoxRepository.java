package com.example.lab4.repository;

import com.example.lab4.Entity.Box;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoxRepository extends CrudRepository<Box,Long> {
    List<Box> findAll();
}
