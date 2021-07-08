package com.banfico.EcomApplication.dao;

import com.banfico.EcomApplication.entity.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepo extends JpaRepository<ShippingEntity,Integer> {

}
