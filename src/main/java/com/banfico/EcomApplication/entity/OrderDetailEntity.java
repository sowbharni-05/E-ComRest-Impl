package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Entity
@Table(name="orderdetail")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private OrderStatus orderstatus;
    private int quantity;
    private boolean payStatus;
    private Date orderDate;

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
