package com.apap.tutorial4.service;

import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.DealerDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DealerServiceImpl implements DealerService{
    @Autowired
    private DealerDB dealerDB;

    @Override
    public Optional<DealerModel> getDealerDetailById(Long id){
        return dealerDB.findById(id);
    }

    @Override
    public void addDealer (DealerModel dealer){
        dealerDB.save(dealer);
    }

    @Override
    public void deleteDealerById(Long dealerId){
        dealerDB.delete(this.getDealerDetailById(dealerId).get());
    }
}
