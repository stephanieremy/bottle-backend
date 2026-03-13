package com.bottle.app.infrastructure.api;

import com.bottle.app.domain.bottle.WineType;

import java.time.LocalDate;
import java.util.UUID;

public record BottleDTO(
        UUID id,
        String designation,
        Integer vintage,
        WineType type,
        LocalDate creationDate,
        String region,
        Integer quantity,
        Double price,
        Integer score,
        String name
) {}
