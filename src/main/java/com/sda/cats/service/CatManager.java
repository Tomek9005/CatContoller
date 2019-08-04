package com.sda.cats.service;

import com.sda.cats.model.Cat;
import com.sda.cats.model.CatDto;
import com.sda.cats.model.CreateCatRequest;
import com.sda.cats.respository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatManager {
    private final CatRepository catRepository;

    @Autowired
    public CatManager(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatDto> getAllCats() {
        return catRepository.findAll().stream()
                //.map(c-> CatMapper.map(c))
                .map(CatMapper::map)
                .collect(Collectors.toList());
    }


    public void saveCat(CreateCatRequest createCatRequest) {
        Cat entity = CatMapper.map(createCatRequest);
        catRepository.save(entity);


    }

    public void deleteCat(long id) {
        catRepository.deleteById(id);
    }

    public Object getCat(Long id) {
        return catRepository.findById(id)
                .map(CatMapper::map)
                .orElse(CatDto.builder().build());

    }

    public void updateCat(Long id, CreateCatRequest createCatRequest) {
       Cat entity = CatMapper.map(createCatRequest);
       entity.setId(id);
        catRepository.save(entity);
    }
}