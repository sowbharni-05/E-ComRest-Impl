package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.entity.OrderDetailEntity;
import com.banfico.EcomApplication.entity.enumtype.ShippingType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Accessors(chain = true)
@Setter
@Getter
@ApiModel(value = "Shipping",description = "Shipping details mapped with its Orders")
public class Shipping {

    private int shippingId;
    @Enumerated(EnumType.ORDINAL)
    private ShippingType shippingtype;
    @ApiModelProperty(name="ShippingCost",notes="Order's shipping cost")
    private int ShippingCost;

    private OrderDetailEntity orderDetails;
}
