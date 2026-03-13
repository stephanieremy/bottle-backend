package com.bottle.app.infrastructure.repository;

import com.bottle.app.domain.bottle.WineType;
import com.bottle.app.infrastructure.repository.entity.BottleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BottleMongoRepository extends MongoRepository<BottleEntity, UUID> {

    @Query("{ $or: [ { $expr: { $eq: [ '?0', 'null' ] } }, { type: ?0 } ] }")
    List<BottleEntity> findAllByType(WineType type);
}

