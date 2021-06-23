package com.banfico.EcomApplication.mapper;

import com.banfico.EcomApplication.entity.CustomerEntity;
import com.banfico.EcomApplication.model.Customer;

public class CustomerMapper {
    public static CustomerEntity DtoToEntity(Customer customer) {
        return new CustomerEntity().setCustomerName(customer.getCustomerName())
                .setEmailId(customer.getEmailId())
                .setAddress(customer.getAddress())
                .setPhNo(customer.getPhNo())
                .setPinCode(customer.getPinCode())
                .setOrderDetails(customer.getOrderDetails());
    }
    public static Customer EntityToDto(CustomerEntity customerEntity) {
        return new Customer().setCustomerId(customerEntity.getCustomerId())
                .setCustomerName(customerEntity.getCustomerName())
                .setEmailId(customerEntity.getEmailId())
                .setAddress(customerEntity.getAddress())
                .setPhNo(customerEntity.getPhNo())
                .setPinCode(customerEntity.getPinCode())
                .setOrderDetails(customerEntity.getOrderDetails());

    }
}
