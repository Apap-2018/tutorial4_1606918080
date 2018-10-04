package com.apap.tutorial4.service;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.CarDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService{
    @Autowired
    private CarDB carDB;

    @Override
    public void addCar(CarModel car){
        carDB.save(car);
    }

    @Override
    public Optional<CarModel> getCarDetailById(Long id){
        return carDB.findById(id);
    }

    @Override
    public void deleteCarById(Long carID){
        carDB.delete(this.getCarDetailById(carID).get());
    }
}
