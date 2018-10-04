package com.apap.tutorial4.repository;

import com.apap.tutorial4.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDB extends JpaRepository<CarModel, Long> {
    CarModel findByType(String type);
}
