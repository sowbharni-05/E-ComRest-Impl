package com.banfico.EcomApplication.mapper;

import com.banfico.EcomApplication.entity.Address;
import com.banfico.EcomApplication.entity.CustomerEntity;
import com.banfico.EcomApplication.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {
    public static CustomerEntity DtoToEntity(Customer customer) {
        List<Address> addressSet = new ArrayList<>(customer.getAddresses());
        return new CustomerEntity().setCustomerName(customer.getCustomerName())
                .setEmailId(customer.getEmailId())
                .setAddresses(addressSet)
                .setPhNo(customer.getPhNo())
                .setOrderDetails(customer.getOrderDetails());
    }
    public static Customer EntityToDto(CustomerEntity customerEntity) {
       List<Address> addressSet = new ArrayList<>(customerEntity.getAddresses());
        return new Customer().setCustomerId(customerEntity.getCustomerId())
                .setCustomerName(customerEntity.getCustomerName())
                .setEmailId(customerEntity.getEmailId())
                .setAddresses(addressSet)
                .setPhNo(customerEntity.getPhNo())
                .setOrderDetails(customerEntity.getOrderDetails());

    }
}
