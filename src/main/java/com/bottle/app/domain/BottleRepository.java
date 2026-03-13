package com.bottle.app.domain;

import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.domain.bottle.WineType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BottleRepository {

    Optional<Bottle> findById(UUID id);
    Bottle save(Bottle bottle);
    List<Bottle> findAll(WineType type);
}
