package com.example.lab4.Controller;

import com.example.lab4.Entity.Car;
import com.example.lab4.service.BoxService;
import com.example.lab4.service.CarService;
import com.example.lab4.service.Car_washesService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.*;
@Controller
@Log
@RequestMapping("/cars")
public class CarController {
 private final CarService carService;
 private final BoxService boxService;
 private final Car_washesService car_washesService;

    public CarController(CarService carService, BoxService boxService, Car_washesService car_washesService) {
        this.carService = carService;
        this.boxService = boxService;
        this.car_washesService = car_washesService;
    }
    @GetMapping
    @ModelAttribute
    public String listCars(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "cars";
    }
    @GetMapping("/new")
    @ModelAttribute
    public String newCar(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("boxes",boxService.getAllBox());
        return "addcar";
    }

}
