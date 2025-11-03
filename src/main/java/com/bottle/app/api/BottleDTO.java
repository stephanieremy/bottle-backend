package com.bottle.app.api;

import com.bottle.app.domain.bottle.WineType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BottleDTO {

    private UUID id;
    private String designation;
    private Integer vintage;
    private WineType type;
}
