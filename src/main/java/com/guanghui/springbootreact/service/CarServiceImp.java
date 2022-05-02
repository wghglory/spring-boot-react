package com.guanghui.springbootreact.service;

import com.guanghui.springbootreact.entity.Car;
import com.guanghui.springbootreact.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }
}
