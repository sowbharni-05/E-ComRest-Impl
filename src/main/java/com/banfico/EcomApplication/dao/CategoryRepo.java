package com.banfico.EcomApplication.dao;

import com.banfico.EcomApplication.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer> {
    List<CategoryEntity> findByCategoryName(@Param("name") String name);

}
