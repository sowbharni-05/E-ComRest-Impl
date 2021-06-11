package com.banfico.EcomApplication.Dao;

import com.banfico.EcomApplication.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetail,Integer> {
}
