package com.bottle.app.domain.bottle;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Bottle {

    private UUID id;
    private String designation;
    private Integer vintage;
    private WineType type;

}
