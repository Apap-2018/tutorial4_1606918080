package com.apap.tutorial4.service;

import com.apap.tutorial4.model.CarModel;

import java.util.Optional;

public interface CarService {
    void addCar (CarModel car);
    void deleteCarById (Long carID);
    Optional<CarModel> getCarDetailById(Long id);
}
