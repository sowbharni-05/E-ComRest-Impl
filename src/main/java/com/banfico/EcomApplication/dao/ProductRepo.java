package com.banfico.EcomApplication.dao;

import com.banfico.EcomApplication.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByOrderByPriceAsc();

}
