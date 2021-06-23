package com.banfico.EcomApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "payment")
@NamedQuery(name = "PaymentEntity.getBypayTypeMatch",
        query = "SELECT p FROM PaymentEntity p WHERE p.payType =:pType"
)
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String payType;

    @JsonManagedReference(value = "paymentRef")
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "paymentDetails")
    private OrderDetailEntity orderDetails;
}
