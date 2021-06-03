package com.banfico.EcomApplication.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shipping")
public class Shipping {
    private int shippingId;
    private String shippingType;
    private int ShippingCost;
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Order.class)
    private Order order;

}
