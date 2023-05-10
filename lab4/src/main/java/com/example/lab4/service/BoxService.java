package com.example.lab4.service;

import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BoxService {
   List<Box>getAllBox();
   void saveBox(Box box);
   void deleteBoxById(Long id);
   Box getBoxById(Long id);
   void editBox(Box box);
}
