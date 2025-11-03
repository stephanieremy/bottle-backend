package com.bottle.app.domain;

import com.bottle.app.domain.bottle.Bottle;

import java.util.Optional;
import java.util.UUID;

public interface BottleRepository {

    Optional<Bottle> findById(UUID id);
    void save(Bottle bottle);
}
