package com.bottle.app.domain.bottle;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Bottle {

    private Long id;
    private String designation;
    private Integer vintage;
    private WineType type;

}
