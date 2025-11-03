package com.bottle.app.domain;

import com.bottle.app.domain.bottle.Bottle;
import org.springframework.stereotype.Service;

@Service
public class BottleService {

private final BottleRepository bottleRepository;


    public BottleService(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    public void createBottle(Bottle bottle){
        bottleRepository.save(bottle);
    }
}
