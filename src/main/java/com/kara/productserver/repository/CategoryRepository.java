package com.kara.productserver.repository;

import com.kara.productserver.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //@Query("SELECET * FROM Cutomer c where c.id != id")
   // Optional<Category> findById(Long id);
   // List<Category> findByName(cihan);
}
