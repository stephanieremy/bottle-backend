package com.bottle.app.domain;

import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.domain.bottle.WineType;

import java.util.List;
import java.util.UUID;

public interface BottleUseCase {
    Bottle createBottle(Bottle bottle);
    Bottle findById(UUID id);
    List<Bottle> findAllBottles(WineType type);
}