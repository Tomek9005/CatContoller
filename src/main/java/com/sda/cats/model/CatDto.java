package com.sda.cats.model;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Data

public class CatDto {
    private Long id;

    private String name;

    private Integer age;

    private boolean hasTail;

    private Colour colour;

}
