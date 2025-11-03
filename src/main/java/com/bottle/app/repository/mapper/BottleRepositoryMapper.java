package com.bottle.app.repository.mapper;

import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.repository.entity.BottleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BottleRepositoryMapper {

    Bottle toBottle(BottleEntity bottleEntity);
    BottleEntity toBottleEntity(Bottle bottle);
}
