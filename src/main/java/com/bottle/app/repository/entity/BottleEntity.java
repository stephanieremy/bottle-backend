package com.bottle.app.repository.entity;

import com.bottle.app.domain.bottle.WineType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
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
    @Field
    @CreatedDate
    private LocalDate creationDate;
    @Field
    @LastModifiedDate
    private LocalDate updateDate;
    @Field
    private String region;
    @Field
    private Integer quantity;
    @Field
    private Double price;
    @Field
    private Integer score;
    @Field
    private String name;
}
