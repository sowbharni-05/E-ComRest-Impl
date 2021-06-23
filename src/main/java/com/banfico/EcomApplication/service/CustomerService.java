package com.banfico.EcomApplication.service;

import com.banfico.EcomApplication.entity.*;
import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.banfico.EcomApplication.model.Customer;
import com.banfico.EcomApplication.model.OrderDetail;
import com.banfico.EcomApplication.model.Payment;
import com.banfico.EcomApplication.model.Shipping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<List<Customer>> getCustomerInfo();
    ResponseEntity<HttpStatus> addCustomerInfo(Customer customer);
    ResponseEntity<HttpStatus> deleteCustomerInfo(int id);
    ResponseEntity<CustomerEntity> updateCustomer(int id, String address, String phno);
    ResponseEntity<HttpStatus> addOrderInfo(OrderDetail ord);
    ResponseEntity<HttpStatus> deleteOrderInfo(int id);
    ResponseEntity<OrderDetailEntity> updateStatus(int id, OrderStatus status);
    ResponseEntity<List<OrderDetail>> getOrderDetail();
    ResponseEntity<List<Shipping>> getShippingInfo();
    ResponseEntity<List<Payment>> getPaymentInfo();
    ResponseEntity<List<Payment>> getPaymentTypeInfo(String pType);



}
