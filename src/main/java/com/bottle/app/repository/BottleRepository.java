package com.bottle.app.repository;

import com.bottle.app.repository.entity.BottleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BottleRepository extends MongoRepository<BottleEntity, UUID> {
}
