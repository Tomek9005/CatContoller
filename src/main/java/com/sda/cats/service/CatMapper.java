package com.sda.cats.service;

import com.sda.cats.model.Cat;
import com.sda.cats.model.CatDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CatMapper {

    CatDto map(Cat entity){
        return CatDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .hasTail(entity.isHasTail())
                .colour(entity.getColour())
                .build();

    }

}
