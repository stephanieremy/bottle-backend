package com.bottle.app.infrastructure.repository.entity;

import com.bottle.app.domain.bottle.WineType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String designation;
    private Integer vintage;
    private WineType type;
    @CreatedDate
    private LocalDate creationDate;
    @LastModifiedDate
    private LocalDate updateDate;
    private String region;
    private Integer quantity;
    private Double price;
    private Integer score;
    private String name;
}
