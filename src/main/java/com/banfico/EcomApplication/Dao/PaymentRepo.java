package com.banfico.EcomApplication.Dao;

import com.banfico.EcomApplication.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {

    List<Payment> getBypayTypeMatch(@Param("pType")String pType);
}
