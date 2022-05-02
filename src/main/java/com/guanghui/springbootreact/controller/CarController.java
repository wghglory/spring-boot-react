package com.guanghui.springbootreact.controller;

import com.guanghui.springbootreact.entity.Car;
import com.guanghui.springbootreact.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//This is not needed if using spring-boot-starter-data-rest!
@RestController
//@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        return carService.findAll();
    }
}
