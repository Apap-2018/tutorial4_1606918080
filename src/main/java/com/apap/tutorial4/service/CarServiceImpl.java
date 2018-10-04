package com.apap.tutorial4.service;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.repository.CarDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService{
    @Autowired
    private CarDB carDB;

    @Override
    public void addCar(CarModel car){
        carDB.save(car);
    }
}
