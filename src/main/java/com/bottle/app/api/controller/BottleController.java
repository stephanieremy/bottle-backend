package com.bottle.app.api.controller;

import com.bottle.app.api.BottleDTO;
import com.bottle.app.api.mapper.BottleMapper;
import com.bottle.app.domain.BottleService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
