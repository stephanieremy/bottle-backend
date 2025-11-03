package com.bottle.app.repository;

import com.bottle.app.repository.entity.BottleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BottleMongoRepository extends MongoRepository<BottleEntity, UUID> {
}
