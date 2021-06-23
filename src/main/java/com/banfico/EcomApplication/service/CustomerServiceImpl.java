package com.banfico.EcomApplication.service;

import com.banfico.EcomApplication.entity.*;
import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.banfico.EcomApplication.exception.DataNotValidException;
import com.banfico.EcomApplication.dao.CustomerRepo;
import com.banfico.EcomApplication.dao.OrderRepo;
import com.banfico.EcomApplication.dao.PaymentRepo;
import com.banfico.EcomApplication.dao.ShippingRepo;
import com.banfico.EcomApplication.mapper.*;
import com.banfico.EcomApplication.model.Customer;
import com.banfico.EcomApplication.model.OrderDetail;
import com.banfico.EcomApplication.model.Payment;
import com.banfico.EcomApplication.model.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    public ResponseEntity<List<Customer>> getCustomerInfo() {
        List<CustomerEntity> savedCustomerEntity =customerrepo.findAll();
        List<Customer> customers= new ArrayList<>();
        for (CustomerEntity customerEntity : savedCustomerEntity) {
           customers= Arrays.asList(CustomerMapper.EntityToDto(customerEntity));
        }
        return ResponseEntity.ok().body(customers);

    }
    @Override
    public ResponseEntity<HttpStatus> addCustomerInfo(Customer customer) {
        try {
            CustomerEntity customerEntity = CustomerMapper.DtoToEntity(customer);
            CustomerEntity savedCustomerEntity = customerrepo.save(customerEntity);
            if (customerrepo.findById(savedCustomerEntity.getCustomerId()).isPresent())
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
    public ResponseEntity<HttpStatus> addOrderInfo(OrderDetail ord) {
        OrderDetailEntity orderDetailEntity = OrderDetailMapper.DtoToEntity(ord);
        try {
            OrderDetailEntity savedOrderEntity = orderrepo.save(orderDetailEntity);
            if (orderrepo.findById(savedOrderEntity.getOrderId()).isPresent())
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
    public ResponseEntity<List<OrderDetail>> getOrderDetail()
    {
        List<OrderDetailEntity> savedOrderEntity =orderrepo.findByOrderByOrderDateAsc();
        List<OrderDetail> orderDetails= new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : savedOrderEntity) {
            orderDetails=Arrays.asList(OrderDetailMapper.EntityToDto(orderDetailEntity));
        }

        return ResponseEntity.ok().body(orderDetails);
    }
    @Override
    public ResponseEntity<List<Shipping>> getShippingInfo()
    {
        List<ShippingEntity> savedShippingEntity=shippingrepo.findAll();
        List<Shipping> shippingList= new ArrayList<>();
        for (ShippingEntity shippingEntity:savedShippingEntity) {
            shippingList=Arrays.asList(ShippingMapper.EntityToDto(shippingEntity));
        }
        return ResponseEntity.ok().body(shippingList);
    }
    @Override
    public ResponseEntity<List<Payment>> getPaymentInfo()
    {
        List<PaymentEntity> savedPaymentEntity =paymentrepo.findAll();
        List<Payment> payments = new ArrayList<>();
        for (PaymentEntity paymentEntity:savedPaymentEntity) {
            payments=Arrays.asList(PaymentMapper.EntityToDto(paymentEntity));
        }
        return ResponseEntity.ok().body(payments);
    }
    @Override
    public ResponseEntity<List<Payment>> getPaymentTypeInfo(String pType)
    {
        List<PaymentEntity> savedPaymentEntity =paymentrepo.getBypayTypeMatch(pType);
        List<Payment> payments = new ArrayList<>();
        for (PaymentEntity paymentEntity:savedPaymentEntity) {
            payments=Arrays.asList(PaymentMapper.EntityToDto(paymentEntity));
        }
        return ResponseEntity.ok().body(payments);
    }


}
