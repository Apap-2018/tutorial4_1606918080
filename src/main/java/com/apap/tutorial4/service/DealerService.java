package com.apap.tutorial4.service;

import com.apap.tutorial4.model.DealerModel;

import java.util.Optional;

public interface DealerService {
    Optional<DealerModel> getDealerDetailById(Long id);

    void addDealer (DealerModel dealer);
}
