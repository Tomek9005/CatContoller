package com.sda.cats.service;

import com.sda.cats.model.Cat;
import com.sda.cats.model.Colour;
import com.sda.cats.respository.CatRepository;
import lombok.Builder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "cats.generate", havingValue = "true")
public class CatGenerator implements InitializingBean {


    private final CatRepository catRepository;

    @Autowired
    public CatGenerator(CatRepository catRepository) {
        this.catRepository = catRepository;

    }
    @Override
    public void afterPropertiesSet() throws Exception {

        Cat c1 = Cat.builder().name("Rys").age(4).hasTail(false).colour(Colour.BLUE).build();
        Cat c2 = Cat.builder().name("NieRys").age(1).hasTail(false).colour(Colour.PINK).build();

        catRepository.save(c1);
        catRepository.save(c2);
    }



}
