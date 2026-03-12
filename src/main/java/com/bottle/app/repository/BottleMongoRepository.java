package com.bottle.app.repository;

import com.bottle.app.repository.entity.BottleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BottleMongoRepository extends MongoRepository<BottleEntity, UUID> {

    @Query("{ $or: [ { $expr: { $eq: [ '?0', 'null' ] } }, { type: ?0 } ] }")
    List<BottleEntity> findAllByType(String type);
}

