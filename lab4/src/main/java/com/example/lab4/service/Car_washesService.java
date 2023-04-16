package com.example.lab4.service;

import com.example.lab4.Entity.Carwashes;

import java.util.List;

public interface Car_washesService {
    List<Carwashes> getAllWash();
    void saveWash(Carwashes carwashes);
    void deleteWashById(Long id);
    Carwashes getWashById(Long id);
    void editWash(Carwashes carwashes);
}
