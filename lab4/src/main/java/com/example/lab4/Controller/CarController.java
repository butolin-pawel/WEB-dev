package com.example.lab4.Controller;

import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import com.example.lab4.Entity.Carwashes;
import com.example.lab4.service.BoxService;
import com.example.lab4.service.CarService;
import com.example.lab4.service.Car_washesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/cars")
public class CarController {
 private final CarService carService;
 private final BoxService boxService;
 private final Car_washesService car_washesService;
@Autowired
    public CarController(CarService carService, BoxService boxService, Car_washesService car_washesService) {
        this.carService = carService;
        this.boxService = boxService;
        this.car_washesService = car_washesService;
    }
    @PostMapping
    public String saveCar(@ModelAttribute("car") Car car ){
    carService.saveCar(car);
    return "redirect:/cars";
    }
    @GetMapping
    public String listCars(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "cars";
    }
    @GetMapping("/newcar")
    public String newCar(Model model){
        Car car = new Car();
        Carwashes car_washer = new Carwashes();
        model.addAttribute("carwash", car_washer);
        model.addAttribute("car", car);
        model.addAttribute("boxes",boxService.getAllBox());
        return "addcar";
    }
    @GetMapping("/newbox")
    public String newBox(Model model){
        Box box = new Box();
        model.addAttribute("box",box);
        return "addbox";
    }
    @PostMapping("/newbox")
    public String newBox(@ModelAttribute("box") Box box){
    boxService.saveBox(box);
        return "redirect:/cars";
    }
    @GetMapping("/box")
    public String listBox(Model model){
        List<Box> listbox= boxService.getAllBox();
        model.addAttribute("boxes",listbox);
        return "boxes";
    }
    @GetMapping ("/del/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }
    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable Long id,Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "editcar";
    }
    @PostMapping("/edit/{id}")
    public  String editCar(@PathVariable Long id,@ModelAttribute("car") Car car){
    Car upcar = carService.getCarById(id);
        upcar.setId(id);
        upcar.setBrand(car.getBrand());
        upcar.setNumber(car.getNumber());
        upcar.setWashes(car.getWashes());
        upcar.setStatus(car.getStatus());
        carService.editCar(upcar);
        return "redirect:/cars";
    }
    @GetMapping("/wash/{id}")
    public String washCar(@PathVariable Long id, Model model){
        model.addAttribute("car",id);
        Carwashes carwashes = new Carwashes();
        model.addAttribute("wash", carwashes);
        model.addAttribute("boxes",boxService.getAllBox());
        return "washcar";
    }
    @PostMapping("/wash/{id}")
    public String savewashCar(@PathVariable Long id, @ModelAttribute("wash")Carwashes carwashes){
      Car svcar = carService.getCarById(id);

        svcar.setId(id);
        svcar.setStatus("Мытая");
        carwashes.setCar(svcar);
        carwashes.setActive(true);
        carService.editCar(svcar);
        car_washesService.saveWash(carwashes);
        return "redirect:/cars";
    }
    @GetMapping("/washes")
    public String allWashes(Model model){
        model.addAttribute("washes",car_washesService.getAllWash());
        return "washes";
    }
    @GetMapping("/box/del/{id}")
    public String delBox(@PathVariable Long id){
        boxService.deleteBoxById(id);
        return "redirect:/cars/box";
    }
    @GetMapping("/box/edit/{id}")
    public String editBox(@PathVariable Long id,Model model){
        model.addAttribute("box",boxService.getBoxById(id));
        return "editbox";
    }
    @PostMapping("/box/edit/{id}")
    public String editBox(@PathVariable Long id,@ModelAttribute("box") Box box){
        Box editbox = boxService.getBoxById(id);
        editbox.setId(id);
        editbox.setName(box.getName());
        editbox.setType(box.getType());
        editbox.setWashes(box.getWashes());
        boxService.editBox(editbox);
        return "redirect:/cars/box";
    }
    @GetMapping("/washes/del/{id}")
    public String delWash(@PathVariable Long id){
        car_washesService.deleteWashById(id);
        return "redirect:/cars/washes";
    }
}
