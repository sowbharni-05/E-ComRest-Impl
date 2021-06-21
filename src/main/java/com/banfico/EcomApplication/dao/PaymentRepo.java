package com.banfico.EcomApplication.dao;

import com.banfico.EcomApplication.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;
import java.util.List;

public interface PaymentRepo extends JpaRepository<PaymentEntity,Integer> {
    List<PaymentEntity> getBypayTypeMatch(@Param("ptype") String pType);
}
