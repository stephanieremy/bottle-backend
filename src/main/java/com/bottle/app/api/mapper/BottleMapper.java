package com.bottle.app.api.mapper;


import com.bottle.app.api.BottleDTO;
import com.bottle.app.domain.bottle.Bottle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BottleMapper {

    BottleDTO toBottleDTO(Bottle bottle);
    Bottle toBottle(BottleDTO bottleDTO);
    List<BottleDTO> toBottleDTOList(List<Bottle> bottleList);
}
