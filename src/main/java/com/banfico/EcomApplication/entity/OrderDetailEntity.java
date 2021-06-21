package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.model.OrderDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="orderdetail")
public class OrderDetailEntity extends OrderDetail {


    @JsonBackReference(value="paymentRef")
    @OneToOne(cascade = CascadeType.ALL,targetEntity = PaymentEntity.class)
    @JoinColumn(name = "payment_id",referencedColumnName = "paymentId")
    private PaymentEntity paymentDetails;

    @JsonBackReference(value = "shippingRef")
    @OneToOne(cascade = CascadeType.ALL,targetEntity = ShippingEntity.class)
    @JoinColumn(name = "shipId",referencedColumnName = "shippingId")
    private ShippingEntity shippingDetails;

    @JsonBackReference(value="customerRef")
    @ManyToOne(targetEntity = CustomerEntity.class)
    @JoinColumn(name="CusId",referencedColumnName = "customerId")
    private CustomerEntity customerDetails;


}
