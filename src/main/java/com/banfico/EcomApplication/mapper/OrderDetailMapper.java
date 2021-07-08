package com.banfico.EcomApplication.mapper;

import com.banfico.EcomApplication.entity.OrderDetailEntity;
import com.banfico.EcomApplication.model.OrderDetail;

public class OrderDetailMapper {
    public static OrderDetailEntity DtoToEntity(OrderDetail orderDetail) {
        return new OrderDetailEntity().setOrderstatus(orderDetail.getOrderstatus())
                .setOrderDate(orderDetail.getOrderDate())
                .setPayStatus(orderDetail.isPayStatus())
                .setQuantity(orderDetail.getQuantity())
                .setCustomerDetails(orderDetail.getCustomerDetails())
                .setPaymentDetails(orderDetail.getPaymentDetails())
                .setShippingDetails(orderDetail.getShippingDetails());

    }
    public static OrderDetail EntityToDto(OrderDetailEntity orderDetailEntity) {
        return new OrderDetail().setOrderId(orderDetailEntity.getOrderId())
                .setOrderstatus(orderDetailEntity.getOrderstatus())
                .setOrderDate(orderDetailEntity.getOrderDate())
                .setPayStatus(orderDetailEntity.isPayStatus())
                .setQuantity(orderDetailEntity.getQuantity())
                .setPaymentDetails(orderDetailEntity.getPaymentDetails())
                .setShippingDetails(orderDetailEntity.getShippingDetails())
                .setCustomerDetails(orderDetailEntity.getCustomerDetails());
    }
}
