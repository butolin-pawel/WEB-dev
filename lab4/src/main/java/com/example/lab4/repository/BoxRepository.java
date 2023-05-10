package com.example.lab4.repository;

import com.example.lab4.Entity.Box;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BoxRepository extends CrudRepository<Box,Long> {
    List<Box> findAll();
}
