package com.sda.cats.respository;

import com.sda.cats.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface CatRepository extends JpaRepository<Cat, Long>  {
}
