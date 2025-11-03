package com.bottle.app.repository;

import com.bottle.app.domain.BottleRepository;
import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.repository.mapper.BottleRepositoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BottleRepositoryAdaptor implements BottleRepository {

    private final BottleMongoRepository bottleMongoRepository;
    private final BottleRepositoryMapper bottleRepositoryMapper;

    public BottleRepositoryAdaptor(BottleMongoRepository bottleMongoRepository, BottleRepositoryMapper bottleRepositoryMapper) {
        this.bottleMongoRepository = bottleMongoRepository;
        this.bottleRepositoryMapper = bottleRepositoryMapper;
    }

    @Override
    public Optional<Bottle> findById(UUID id) {
        bottleMongoRepository.findById(id).orElseThrow(()-> new RuntimeException("Bottle not found."));
        return bottleMongoRepository.findById(id).map(bottleRepositoryMapper::toBottle);
    }

    @Override
    public void save(Bottle bottle) {
        bottleMongoRepository.save(bottleRepositoryMapper.toBottleEntity(bottle));
    }

    @Override
    public List<Bottle> findAll() {
        return bottleRepositoryMapper.toBottleList(bottleMongoRepository.findAll());
    }


}
