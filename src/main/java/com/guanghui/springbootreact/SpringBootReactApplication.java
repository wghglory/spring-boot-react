package com.guanghui.springbootreact;

import com.guanghui.springbootreact.domain.Car;
import com.guanghui.springbootreact.domain.CarRepository;
import com.guanghui.springbootreact.domain.Owner;
import com.guanghui.springbootreact.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootReactApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootReactApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = Owner.builder().firstName("Derek").lastName("Wang").build();
        Owner owner2 = Owner.builder().firstName("Iris").lastName("Yuan").build();
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        carRepository.save(Car.builder().owner(owner1).brand("Ford").color("Red").model("Mustang").price(59000).registerNumber("ADF-1121").year(2021).build());
        carRepository.save(Car.builder().owner(owner2).brand("Nissan").color("White").model("Leaf").price(29000).registerNumber("SSJ-3021").year(2019).build());
        carRepository.save(Car.builder().owner(owner1).brand("Toyota").color("Silver").model("Prius").price(39000).registerNumber("KKO-2121").year(2020).build());

        for (Car car : carRepository.findAll()) {
//        TODO:    Owner owner = car.getOwner();
//            Method threw 'org.hibernate.LazyInitializationException' exception. Cannot evaluate com.guanghui.springbootreact.domain.Car.toString()
            logger.info(car.getBrand() + " / " + car.getModel() + " / " + car.getYear());
        }
    }
}
