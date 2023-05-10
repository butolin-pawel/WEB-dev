package com.example.lab4.service.impl;

import com.example.lab4.Entity.Box;
import com.example.lab4.repository.BoxRepository;
import com.example.lab4.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {

    private final BoxRepository boxRepository;
    @Autowired
    public BoxServiceImpl(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }


    @Override

    public List<Box> getAllBox() {
        return boxRepository.findAll();
    }

    @Override
    public void saveBox(Box box) {
        boxRepository.save(box);
    }

    @Override
    public void deleteBoxById(Long id) {
        boxRepository.deleteById(id);
    }

    @Override
    public Box getBoxById(Long id) {
        return boxRepository.findById(id).get();
    }

    @Override
    public void editBox(Box box) {
        boxRepository.save(box);
    }
}
