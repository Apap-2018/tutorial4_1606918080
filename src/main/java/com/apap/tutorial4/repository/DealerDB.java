package com.apap.tutorial4.repository;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerDB extends JpaRepository<DealerModel, Long> {
}

