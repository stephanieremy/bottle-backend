package com.bottle.app.api.controller;

import com.bottle.app.api.BottleDTO;
import com.bottle.app.api.mapper.BottleMapper;
import com.bottle.app.domain.BottleService;
import org.springframework.web.bind.annotation.*;

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
    public void saveBottle(@RequestBody BottleDTO bottleDTO){
        bottleService.createBottle(bottleMapper.toBottle(bottleDTO));
    }

    @GetMapping("{id}")
    public BottleDTO getBottle(@PathVariable UUID id){
      return  bottleMapper.toBottleDTO(bottleService.findById(id));
    }

    @GetMapping()
    public List<BottleDTO> getAllBottles(@RequestParam(required = false) String type){
        return bottleMapper.toBottleDTOList(bottleService.findAllBottles(type));
    }


}
