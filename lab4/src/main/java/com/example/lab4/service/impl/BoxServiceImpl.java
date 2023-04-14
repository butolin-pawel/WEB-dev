package com.example.lab4.service.impl;

import com.example.lab4.Entity.Box;
import com.example.lab4.repository.BoxRepository;
import com.example.lab4.service.BoxService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {
    private final BoxRepository boxRepository;

    public BoxServiceImpl(BoxRepository boxRepository) {
        super();
        this.boxRepository = boxRepository;
    }

    @Override
    public List<Box> getAllBox() {
        return boxRepository.findAll();
    }
}
