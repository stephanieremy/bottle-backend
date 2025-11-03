package com.bottle.app.domain;

import com.bottle.app.domain.bottle.Bottle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BottleService {

private final BottleRepository bottleRepository;


    public BottleService(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    public void createBottle(Bottle bottle){
        bottleRepository.save(bottle);
    }

    public Bottle findById(UUID id){
        return bottleRepository.findById(id).orElseThrow(()-> new BottleNotFoundException("Bottle not found."));
    }

    public List<Bottle> findAll(){
        return bottleRepository.findAll();
    }

    public static class BottleNotFoundException extends RuntimeException {
        public BottleNotFoundException(String message) {
            super(message);
        }
    }
}
