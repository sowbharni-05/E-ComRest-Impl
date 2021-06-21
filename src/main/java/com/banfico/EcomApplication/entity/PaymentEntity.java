package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.model.Payment;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
@NamedQuery(name = "PaymentEntity.getBypayTypeMatch",
        query = "SELECT p FROM PaymentEntity p WHERE p.payType =:pType"
)
public class PaymentEntity extends Payment {

    private String payType;

    @JsonManagedReference(value = "paymentRef")
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "paymentDetails")
    private OrderDetailEntity orderDetails;
}
