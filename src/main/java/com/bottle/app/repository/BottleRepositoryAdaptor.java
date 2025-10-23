package com.bottle.app.repository;

import org.springframework.stereotype.Component;

@Component
public class BottleRepositoryAdaptor implements com.bottle.app.domain.BottleRepository {

    private final BottleRepository bottleRepository;

    public BottleRepositoryAdaptor(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }


}
