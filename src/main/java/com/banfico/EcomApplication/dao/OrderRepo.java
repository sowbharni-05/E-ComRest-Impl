package com.banfico.EcomApplication.dao;

import com.banfico.EcomApplication.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderDetailEntity,Integer> {

    List<OrderDetailEntity> findByOrderByOrderDateAsc();
}
