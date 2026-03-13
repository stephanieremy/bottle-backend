package com.bottle.app.infrastructure.api.controller;

import com.bottle.app.domain.BottleUseCase;
import com.bottle.app.infrastructure.api.BottleDTO;
import com.bottle.app.infrastructure.api.mapper.BottleMapper;
import com.bottle.app.domain.bottle.WineType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("bottle")
public class BottleController {

    private final BottleUseCase bottleUseCase;
    private final BottleMapper bottleMapper;

    public BottleController(BottleUseCase bottleUseCase, BottleMapper bottleMapper) {
        this.bottleUseCase = bottleUseCase;
        this.bottleMapper = bottleMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BottleDTO saveBottle(@RequestBody BottleDTO bottleDTO) {
        return bottleMapper.toBottleDTO(
                bottleUseCase.createBottle(bottleMapper.toBottle(bottleDTO))
        );
    }

    @GetMapping("{id}")
    public BottleDTO getBottle(@PathVariable UUID id){
      return  bottleMapper.toBottleDTO(bottleUseCase.findById(id));
    }

    @GetMapping()
    public List<BottleDTO> getAllBottles(@RequestParam(required = false) WineType type){
        return bottleMapper.toBottleDTOList(bottleUseCase.findAllBottles(type));
    }


}
