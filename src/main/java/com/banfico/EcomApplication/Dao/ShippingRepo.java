package com.banfico.EcomApplication.Dao;

import com.banfico.EcomApplication.Model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping,Integer> {

}
