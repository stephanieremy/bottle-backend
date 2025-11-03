package com.bottle.app.api.mapper;


import com.bottle.app.api.BottleDTO;
import com.bottle.app.domain.bottle.Bottle;
import org.mapstruct.Mapper;

@Mapper
public interface BottleMapper {

    BottleDTO toBottleDTO(Bottle bottle);
}
