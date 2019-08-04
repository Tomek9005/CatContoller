package com.sda.cats.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity(name="cats")
@Builder
@Getter
public class Cat {

    @Id
    @GeneratedValue

    private Long id;

    private String name;

    private Integer age;

    private boolean hasTail;

    @Enumerated(EnumType.STRING)
    private Colour colour;



}
