package com.sda.cats.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity(name="cats")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
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
