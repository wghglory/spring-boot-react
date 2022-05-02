package com.guanghui.springbootreact;

import com.guanghui.springbootreact.domain.Car;
import com.guanghui.springbootreact.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReactApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootReactApplication.class);

    @Autowired
    private CarRepository carRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        carRepository.save(Car.builder().brand("Ford").color("Red").model("Mustang").price(59000).registerNumber("ADF-1121").year(2021).build());
        carRepository.save(Car.builder().brand("Nissan").color("White").model("Leaf").price(29000).registerNumber("SSJ-3021").year(2019).build());
        carRepository.save(Car.builder().brand("Toyota").color("Silver").model("Prius").price(39000).registerNumber("KKO-2121").year(2020).build());

        for (Car car : carRepository.findAll()) {
            logger.info(car.getBrand() + " / " + car.getModel());
        }
    }
}
