package com.sda.cats.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
