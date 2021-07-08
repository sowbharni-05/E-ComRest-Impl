package com.banfico.EcomApplication.mapper;

import com.banfico.EcomApplication.entity.PaymentEntity;
import com.banfico.EcomApplication.model.Payment;

public class PaymentMapper {
    public static PaymentEntity DtoToEntity(Payment payment) {
        return new PaymentEntity().setPayType(payment.getPayType());
    }
    public static Payment EntityToDto(PaymentEntity paymentEntity) {
        return new Payment().setPaymentId(paymentEntity.getPaymentId())
                .setPayType(paymentEntity.getPayType())
                .setOrderDetails(paymentEntity.getOrderDetails());
    }

}
