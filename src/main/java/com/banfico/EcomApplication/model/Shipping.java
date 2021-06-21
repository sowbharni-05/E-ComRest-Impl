package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.entity.enumtype.ShippingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Setter
@Getter
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shippingId;
    @Enumerated(EnumType.ORDINAL)
    private ShippingType shippingtype;
}
