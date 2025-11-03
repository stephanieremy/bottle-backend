package com.bottle.app.api;

import com.bottle.app.domain.bottle.WineType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BottleDTO {

    private Long id;
    private String designation;
    private Integer vintage;
    private WineType type;
}
