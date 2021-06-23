package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.entity.enumtype.ShippingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name="shipping")
public class ShippingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shippingId;
    private ShippingType shippingtype;
    private int ShippingCost;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = OrderDetailEntity.class,mappedBy = "shippingDetails")
    private OrderDetailEntity orderDetails;

}
