package com.bottle.app.repository;

import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.repository.mapper.BottleMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class BottleRepositoryAdaptor implements com.bottle.app.domain.BottleRepository {

    private final BottleRepository bottleRepository;
    private final BottleMapper bottleMapper;

    public BottleRepositoryAdaptor(BottleRepository bottleRepository, BottleMapper bottleMapper) {
        this.bottleRepository = bottleRepository;
        this.bottleMapper = bottleMapper;
    }

    public Optional<Bottle> findById(UUID id){
        bottleRepository.findById(id).orElseThrow(()-> new RuntimeException("Bottle not found."));
        return bottleRepository.findById(id).map(bottleMapper::toBottle);
    }

    @Override
    public void save(Bottle bottle) {
        bottleRepository.save(bottleMapper.toBottleEntity(bottle));
    }


}
