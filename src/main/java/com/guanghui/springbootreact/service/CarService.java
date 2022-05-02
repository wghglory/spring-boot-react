package com.guanghui.springbootreact.service;


import com.guanghui.springbootreact.entity.Car;

public interface CarService {
    Iterable<Car> findAll();
}
