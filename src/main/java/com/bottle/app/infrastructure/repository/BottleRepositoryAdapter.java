package com.bottle.app.infrastructure.repository;

import com.bottle.app.domain.BottleRepository;
import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.domain.bottle.WineType;
import com.bottle.app.infrastructure.repository.mapper.BottleRepositoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BottleRepositoryAdapter implements BottleRepository {

    private final BottleMongoRepository bottleMongoRepository;
    private final BottleRepositoryMapper bottleRepositoryMapper;

    public BottleRepositoryAdapter(BottleMongoRepository bottleMongoRepository, BottleRepositoryMapper bottleRepositoryMapper) {
        this.bottleMongoRepository = bottleMongoRepository;
        this.bottleRepositoryMapper = bottleRepositoryMapper;
    }

    @Override
    public Optional<Bottle> findById(UUID id) {
        return bottleMongoRepository.findById(id).map(bottleRepositoryMapper::toBottle);
    }

    @Override
    public Bottle save(Bottle bottle) {
        bottleMongoRepository.save(bottleRepositoryMapper.toBottleEntity(bottle));
        return bottle;
    }

    @Override
    public List<Bottle> findAll(WineType type) {
        return bottleRepositoryMapper.toBottleList(bottleMongoRepository.findAllByType(type));
    }


}
