package com.bottle.app.repository.entity;

import com.bottle.app.domain.bottle.WineType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class BottleEntity {

    @Id
    private UUID id;
    @Field
    private String designation;
    @Field
    private Integer vintage;
    @Field
    private WineType type;
}
