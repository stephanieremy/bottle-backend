package com.bottle.app.api.controller;

import com.bottle.app.api.BottleDTO;
import com.bottle.app.domain.BottleService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bottle")
public class BottleController {

    private final BottleService bottleService;

    public BottleController(BottleService bottleService) {
        this.bottleService = bottleService;
    }


    @PutMapping("{id")
    public void saveBottle(BottleDTO bottleDTO){
    }


}
