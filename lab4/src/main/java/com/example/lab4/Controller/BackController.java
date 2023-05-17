package com.example.lab4.Controller;

import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import com.example.lab4.Entity.Carwashes;
import com.example.lab4.service.BoxService;
import com.example.lab4.service.CarService;
import com.example.lab4.service.Car_washesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BackController {

    private final CarService carService;
    private final BoxService boxService;
    private final Car_washesService car_washesService;
    public BackController(CarService carService, BoxService boxService, Car_washesService car_washesService) {
        this.carService = carService;
        this.boxService = boxService;
        this.car_washesService = car_washesService;
    }
    //CARS
    @GetMapping(value = "/cars")
    public List getCars(){

        System.out.println("ALL");
        return carService.getAllCars();
    }
    @DeleteMapping(value = "/cars/{id}")
    public void delCar(@PathVariable Long id){
        System.out.println(id +" DELETE");
        carService.deleteCarById(id);
    }
    @PostMapping(value="/cars")
    public void saveCar(@RequestBody Car car){
        System.out.println(car.getNumber() + " SAVED ");
        carService.saveCar(car);
    }
    @GetMapping(value = "/cars/{id}")
    public Car carById(@PathVariable Long id){

        System.out.println(id + " I did it");
        return carService.getCarById(id);
    }
    @PutMapping(value = "/cars")
    public void editCar(@RequestBody Car car){

        System.out.println(car.getNumber() + " EDITING");
        carService.editCar(car);
    }
//    ********************
    //BOXES
//    ***********************
    @GetMapping(value = "/boxes")
    public List getBoxes(){
        return boxService.getAllBox();
    }
    @DeleteMapping(value = "/boxes/{id}")
    public void delBox(@PathVariable Long id){
        boxService.deleteBoxById(id);
    }
    @PostMapping(value="/boxes")
    public void saveBox(@RequestBody Box box){
        boxService.saveBox(box);
    }
    @GetMapping(value = "/boxes/{id}")
    public Box boxById(@PathVariable Long id){
        return boxService.getBoxById(id);
    }
    @PutMapping(value = "/boxes")
    public void editBox(@RequestBody Box box){
        boxService.editBox(box);
    }
    //    ********************
    //WASHES
//    ***********************
    @GetMapping(value = "/washes")
    public List getWashes(){
        return car_washesService.getAllWash();
    }
    @DeleteMapping(value = "/washes/{id}")
    public void delWash(@PathVariable Long id){
        car_washesService.deleteWashById(id);
    }
    @PostMapping(value="/washes")
    public void saveWash(@RequestBody Carwashes carwashes){
        Car car = carService.getCarById(carwashes.getCar().getId());
        car.setStatus("Мытая");
        carService.editCar(car);
        car_washesService.saveWash(carwashes);
    }
    @GetMapping(value = "/washes/{id}")
    public Carwashes washById(@PathVariable Long id){
        return car_washesService.getWashById(id);
    }
    @PutMapping(value = "/washes")
    public void editWash(@RequestBody Carwashes carwashes){
        car_washesService.editWash(carwashes);
    }
}
