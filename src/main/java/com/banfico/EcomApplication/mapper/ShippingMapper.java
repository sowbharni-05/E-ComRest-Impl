package com.banfico.EcomApplication.mapper;

import com.banfico.EcomApplication.entity.ShippingEntity;
import com.banfico.EcomApplication.model.Shipping;

public class ShippingMapper {
    public static ShippingEntity DtoToEntity(Shipping shipping) {
        return new ShippingEntity().setShippingtype(shipping.getShippingtype())
                .setShippingCost(shipping.getShippingCost());
    }
    public static Shipping EntityToDto(ShippingEntity shippingEntity) {
        return new Shipping().setShippingId(shippingEntity.getShippingId())
                .setShippingtype(shippingEntity.getShippingtype())
                .setShippingCost(shippingEntity.getShippingCost())
                .setOrderDetails(shippingEntity.getOrderDetails());
    }
}
