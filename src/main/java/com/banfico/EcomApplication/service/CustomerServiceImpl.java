package com.banfico.EcomApplication.service;

import com.banfico.EcomApplication.entity.*;
import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.banfico.EcomApplication.exception.DataNotValidException;
import com.banfico.EcomApplication.dao.CustomerRepo;
import com.banfico.EcomApplication.dao.OrderRepo;
import com.banfico.EcomApplication.dao.PaymentRepo;
import com.banfico.EcomApplication.dao.ShippingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerrepo;
    @Autowired private OrderRepo orderrepo;
    @Autowired private ShippingRepo shippingrepo;
    @Autowired private PaymentRepo paymentrepo;

    private CustomerEntity savedCus;
    private OrderDetailEntity savedOrder;

    @Override
    public ResponseEntity<List<CustomerEntity>> getCustomerInfo() {
        List<CustomerEntity> savedCus=customerrepo.findAll();
        return ResponseEntity.ok().body(savedCus);

    }
    @Override
    public ResponseEntity<HttpStatus> addCustomerInfo(CustomerEntity customerEntity) {
        savedCus=null;
        try {
            savedCus = customerrepo.save(customerEntity);
            if (customerrepo.findById(savedCus.getCustomerId()).isPresent())
                return new ResponseEntity<>(HttpStatus.CREATED);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e)
        {
            throw new DataNotValidException(e);
        }
    }
    @Override
    public ResponseEntity<HttpStatus> deleteCustomerInfo(int id){
        if(customerrepo.findById(id).isPresent()){
            CustomerEntity deleteCustomerEntity =customerrepo.getById(id);
            customerrepo.delete(deleteCustomerEntity);
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.notFound().build();
    }
    @Override
    public ResponseEntity<CustomerEntity> updateCustomer(int id, String address, String phno) {
        savedCus = null;
        try{
        if (customerrepo.findById(id).isPresent()) {
            savedCus = customerrepo.getById(id);
            savedCus.setAddress(address);
            savedCus.setPhNo(phno);
            return new ResponseEntity<>(customerrepo.save(savedCus),HttpStatus.OK);
        }
            return ResponseEntity.notFound().build();}

        catch (Exception e){
            throw new DataNotValidException(e);
        }

    }
    @Override
    public ResponseEntity<HttpStatus> addOrderInfo(OrderDetailEntity ord) {
        savedOrder=null;
        try {
           savedOrder = orderrepo.save(ord);
           if (orderrepo.findById(savedOrder.getOrderId()).isPresent())
               return new ResponseEntity<>(HttpStatus.CREATED);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
       catch (Exception e)
       {
           throw new DataNotValidException(e);
       }
    }
    @Override
    public ResponseEntity<HttpStatus> deleteOrderInfo(int id) {
        if (orderrepo.findById(id).isPresent()) {
            OrderDetailEntity deleteOrder = orderrepo.getById(id);
            orderrepo.delete(deleteOrder);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<OrderDetailEntity> updateStatus(int id, OrderStatus status) {
        savedOrder = null;
        if (orderrepo.findById(id).isPresent()) {
            savedOrder = orderrepo.getById(id);
            savedOrder.setOrderstatus(status);
            return new ResponseEntity<>(orderrepo.save(savedOrder),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<List<OrderDetailEntity>> getOrderDetail()
    {
        List<OrderDetailEntity> orderdetail =orderrepo.findByOrderByOrderDateAsc();
        return ResponseEntity.ok().body(orderdetail);
    }
    @Override
    public ResponseEntity<List<ShippingEntity>> getShippingInfo()
    {
        List<ShippingEntity> savedshipping=shippingrepo.findAll();
        return ResponseEntity.ok().body(savedshipping);
    }
    @Override
    public ResponseEntity<List<PaymentEntity>> getPaymentInfo()
    {
        List<PaymentEntity> savedpayment =paymentrepo.findAll();
        return ResponseEntity.ok().body(savedpayment);
    }
    @Override
    public ResponseEntity<List<PaymentEntity>> getPaymentTypeInfo(String pType)
    {
        List<PaymentEntity> savedpayment =paymentrepo.getBypayTypeMatch(pType);
        return ResponseEntity.ok().body(savedpayment);
    }


}
