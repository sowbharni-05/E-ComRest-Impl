package com.banfico.EcomApplication.Dao;

import com.banfico.EcomApplication.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
