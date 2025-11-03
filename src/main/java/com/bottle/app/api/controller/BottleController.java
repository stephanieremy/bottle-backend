package com.bottle.app.api.controller;

import com.bottle.app.api.BottleDTO;
import com.bottle.app.api.mapper.BottleMapper;
import com.bottle.app.domain.BottleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("bottle")
public class BottleController {

    private final BottleService bottleService;
    private final BottleMapper bottleMapper;

    public BottleController(BottleService bottleService, BottleMapper bottleMapper) {
        this.bottleService = bottleService;
        this.bottleMapper = bottleMapper;
    }

    @PutMapping()
    public void saveBottle(BottleDTO bottleDTO){
        bottleService.createBottle(bottleMapper.toBottle(bottleDTO));
    }

    @GetMapping("{id}")
    public BottleDTO getBottle(UUID id){
      return  bottleMapper.toBottleDTO(bottleService.findById(id));
    }

    @GetMapping()
    public List<BottleDTO> getAllBottles(){
        return bottleMapper.toBottleDTOList(bottleService.findAll());
    }


}
