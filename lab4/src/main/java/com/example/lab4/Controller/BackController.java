package com.example.lab4.Controller;

import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import com.example.lab4.Entity.Carwashes;
import com.example.lab4.service.BoxService;
import com.example.lab4.service.CarService;
import com.example.lab4.service.Car_washesService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BackController {

    private final CarService carService;
    private final BoxService boxService;
    private final Car_washesService car_washesService;

    private final SimpMessagingTemplate messagingTemplate;
    public BackController(CarService carService, BoxService boxService, Car_washesService car_washesService, SimpMessagingTemplate messagingTemplate) {
        this.carService = carService;
        this.boxService = boxService;
        this.car_washesService = car_washesService;
        this.messagingTemplate = messagingTemplate;
    }
    //CARS
    @GetMapping(value = "/cars")
    public List getCars(){

        return carService.getAllCars();
    }
    @DeleteMapping(value = "/cars/{id}")
    public void delCar(@PathVariable Long id){
        carService.deleteCarById(id);
        updateCar();
    }
    @PostMapping(value="/cars")
    public void saveCar(@RequestBody Car car){
        carService.saveCar(car);
        updateCar();
    }
    @GetMapping(value = "/cars/{id}")
    public Car carById(@PathVariable Long id){

        return carService.getCarById(id);
    }
    @PutMapping(value = "/cars")
    public void editCar(@RequestBody Car car){
        carService.editCar(car);
        updateCar();

    }
    @MessageMapping("/car")
    public void updateCar() {
        messagingTemplate.convertAndSend("/topic/cars", carService.getAllCars());
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
        updateData();
    }
    @PostMapping(value="/boxes")
    public void saveBox(@RequestBody Box box){
        boxService.saveBox(box);
        updateData();
    }
    @GetMapping(value = "/boxes/{id}")
    public Box boxById(@PathVariable Long id){
        return boxService.getBoxById(id);
    }
    @PutMapping(value = "/boxes")
    public void editBox(@RequestBody Box box){
        boxService.editBox(box);
        updateData();

    }
    @MessageMapping("/box")
    public void updateData() {
        messagingTemplate.convertAndSend("/topic/boxes", boxService.getAllBox());
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
        updateWash();
    }
    @PostMapping(value="/washes")
    public void saveWash(@RequestBody Carwashes carwashes){
        Car car = carService.getCarById(carwashes.getCar().getId());
        car.setStatus("Мытая");
        carService.editCar(car);
        car_washesService.saveWash(carwashes);
        updateWash();
        updateCar();
    }
    @GetMapping(value = "/washes/{id}")
    public Carwashes washById(@PathVariable Long id){
        return car_washesService.getWashById(id);
    }
    @PutMapping(value = "/washes")
    public void editWash(@RequestBody Carwashes carwashes){
        car_washesService.editWash(carwashes);
        updateWash();
    }

    @MessageMapping("/wash")
    public void updateWash() {
        messagingTemplate.convertAndSend("/topic/washes", car_washesService.getAllWash());
    }
}
