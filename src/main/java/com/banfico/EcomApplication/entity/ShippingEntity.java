package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.model.Shipping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="shipping")
public class ShippingEntity extends Shipping {

    private int ShippingCost;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = OrderDetailEntity.class,mappedBy = "shippingDetails")
    private OrderDetailEntity orderDetails;

}
