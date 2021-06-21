package com.banfico.EcomApplication.service;

import com.banfico.EcomApplication.entity.*;
import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    public ResponseEntity<List<CustomerEntity>> getCustomerInfo();
    public ResponseEntity<HttpStatus> addCustomerInfo(CustomerEntity customerEntity);
    public ResponseEntity<HttpStatus> deleteCustomerInfo(int id);
    public ResponseEntity<CustomerEntity> updateCustomer(int id, String address, String phno);
    public ResponseEntity<HttpStatus> addOrderInfo(OrderDetailEntity ord);
    public ResponseEntity<HttpStatus> deleteOrderInfo(int id);
    public ResponseEntity<OrderDetailEntity> updateStatus(int id, OrderStatus status);
    public ResponseEntity<List<OrderDetailEntity>> getOrderDetail();
    public ResponseEntity<List<ShippingEntity>> getShippingInfo();
    public ResponseEntity<List<PaymentEntity>> getPaymentInfo();
    public ResponseEntity<List<PaymentEntity>> getPaymentTypeInfo(String pType);



}
