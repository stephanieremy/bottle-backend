package com.bottle.app.application;

import com.bottle.app.domain.BottleNotFoundException;
import com.bottle.app.domain.BottleRepository;
import com.bottle.app.domain.BottleUseCase;
import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.domain.bottle.WineType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BottleService implements BottleUseCase {

private final BottleRepository bottleRepository;


    public BottleService(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    public Bottle createBottle(Bottle bottle){
        bottle.setId(UUID.randomUUID());
        return bottleRepository.save(bottle);
    }

    public Bottle findById(UUID id){
        return bottleRepository.findById(id).orElseThrow(()-> new BottleNotFoundException("Bottle not found."));
    }

    public List<Bottle> findAllBottles(WineType type){
        return bottleRepository.findAll(type);
    }

}
