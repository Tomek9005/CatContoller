package com.sda.cats.service;

import com.sda.cats.model.CatDto;
import com.sda.cats.respository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatManager {
    private final CatRepository catRepository;

    @Autowired
    public CatManager( CatRepository catRepository){
        this.catRepository = catRepository;
    }
    List<CatDto> getAllCats(){
        return catRepository.findAll().stream()
                //.map(c-> CatMapper.map(c))
                .map(CatMapper::map)
                .collect(Collectors.toList());
    }


}
