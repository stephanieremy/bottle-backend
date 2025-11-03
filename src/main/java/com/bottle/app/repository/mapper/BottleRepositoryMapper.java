package com.bottle.app.repository.mapper;

import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.repository.entity.BottleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BottleRepositoryMapper {

    Bottle toBottle(BottleEntity bottleEntity);
    BottleEntity toBottleEntity(Bottle bottle);
    List<Bottle> toBottleList(List<BottleEntity> bottleEntityList);
}
