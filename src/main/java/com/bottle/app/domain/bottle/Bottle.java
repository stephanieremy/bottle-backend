package com.bottle.app.domain.bottle;

import lombok.*;

import java.time.LocalDate;
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
    private LocalDate creationDate;
    private String region;
    private Integer quantity;
    private Double price;
    private Integer score;
    private String name;
}
