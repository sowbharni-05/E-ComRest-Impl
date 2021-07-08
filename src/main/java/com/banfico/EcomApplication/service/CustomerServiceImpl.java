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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class.getName());
    @Autowired
    private CustomerRepo customerrepo;
    @Autowired
    private OrderRepo orderrepo;
    @Autowired
    private ShippingRepo shippingrepo;
    @Autowired
    private PaymentRepo paymentrepo;

    @Override
    public ResponseEntity<List<Customer>> getCustomerInfo() {
        List<CustomerEntity> savedCustomerEntity = customerrepo.findAll();
        List<Customer> customers = new ArrayList<>();
        for (CustomerEntity customerEntity : savedCustomerEntity) {
            customers.add(CustomerMapper.EntityToDto(customerEntity));
        }
        logger.info("Get Customer Details");
        return ResponseEntity.ok().body(customers);

    }

    @Override
    public ResponseEntity<HttpStatus> addCustomerInfo(Customer customer) {
        CustomerEntity customerEntity = CustomerMapper.DtoToEntity(customer);
        try {
            CustomerEntity savedCustomerEntity = customerrepo.save(customerEntity);
            if (customerrepo.findById(savedCustomerEntity.getCustomerId()).isPresent()) {
                logger.info("Created Customer Record CustomerId {}", savedCustomerEntity.getCustomerId());
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            logger.error("Failed to Create New Customer Record");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            logger.error("Invalid MethodArgument");
            throw new DataNotValidException(e);
        }

    }

    @Override
    public ResponseEntity<HttpStatus> deleteCustomerInfo(int id) {
        if (customerrepo.findById(id).isPresent()) {
            CustomerEntity deleteCustomerEntity = customerrepo.getById(id);
            customerrepo.delete(deleteCustomerEntity);
            logger.info("Deleted Customer Record CustomerId {}", deleteCustomerEntity.getCustomerId());
            return ResponseEntity.noContent().build();
        }
        logger.error("Not Found");
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<CustomerEntity> updateCustomer(int id, String phno, Address address) {
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        try {
            if (customerrepo.findById(id).isPresent()) {
                CustomerEntity savedCus = customerrepo.getById(id);
                savedCus.setAddresses(addressList);
                savedCus.setPhNo(phno);
                logger.info("Update Customer Record CustomerId {}", id);
                return new ResponseEntity<>(customerrepo.save(savedCus), HttpStatus.OK);
            }
            logger.error("No Record Found to Update");
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error("Invalid MethodArgument");
            throw new DataNotValidException(e);
        }

    }
    @Override
    public ResponseEntity<HttpStatus> addOrderInfo(OrderDetail ord) {
        OrderDetailEntity orderDetailEntity = OrderDetailMapper.DtoToEntity(ord);
        try {
            OrderDetailEntity savedOrderEntity = orderrepo.save(orderDetailEntity);
            if (orderrepo.findById(savedOrderEntity.getOrderId()).isPresent())
            {
                logger.info("Created Order Record OrderId {}",savedOrderEntity.getOrderId());
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            logger.error("Failed to Create New Order Record");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
       catch (Exception e)
       {
           logger.error("Invalid MethodArgument");
           throw new DataNotValidException(e);
       }
    }
    @Override
    public ResponseEntity<HttpStatus> deleteOrderInfo(int id) {
        if (orderrepo.findById(id).isPresent()) {
            OrderDetailEntity deleteOrder = orderrepo.getById(id);
            orderrepo.delete(deleteOrder);
            logger.info("Deleted Customer Record CustomerId {}",deleteOrder.getOrderId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.error("Not Found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<OrderDetailEntity> updateStatus(int id, OrderStatus status) {
        OrderDetailEntity savedOrder;
        if (orderrepo.findById(id).isPresent()) {
            savedOrder = orderrepo.getById(id);
            savedOrder.setOrderstatus(status);
            logger.info("Update Order Record OrderId {}",id);
            return new ResponseEntity<>(orderrepo.save(savedOrder),HttpStatus.OK);
        }
        logger.error("No Record Found to Update");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<List<OrderDetail>> getOrderDetail()
    {
        List<OrderDetailEntity> savedOrderEntity =orderrepo.findByOrderByOrderDateAsc();
        List<OrderDetail> orderDetails= new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : savedOrderEntity) {
            orderDetails.add(OrderDetailMapper.EntityToDto(orderDetailEntity));
        }
        logger.info("Get Order Details");
        return ResponseEntity.ok().body(orderDetails);
    }
    @Override
    public ResponseEntity<List<Shipping>> getShippingInfo()
    {
        List<ShippingEntity> savedShippingEntity=shippingrepo.findAll();
        List<Shipping> shippingList= new ArrayList<>();
        for (ShippingEntity shippingEntity:savedShippingEntity) {
            shippingList.add(ShippingMapper.EntityToDto(shippingEntity));
        }
        logger.info("Get Shipping Details");
        return ResponseEntity.ok().body(shippingList);
    }
    @Override
    public ResponseEntity<List<Payment>> getPaymentInfo()
    {
        List<PaymentEntity> savedPaymentEntity =paymentrepo.findAll();
        List<Payment> payments = new ArrayList<>();
        for (PaymentEntity paymentEntity:savedPaymentEntity) {
            payments.add(PaymentMapper.EntityToDto(paymentEntity));
        }
        logger.info("Get Payment Details");
        return ResponseEntity.ok().body(payments);
    }
    @Override
    public ResponseEntity<List<Payment>> getPaymentTypeInfo(String pType)
    {
        List<PaymentEntity> savedPaymentEntity =paymentrepo.getBypayTypeMatch(pType);
        List<Payment> payments = new ArrayList<>();
        for (PaymentEntity paymentEntity:savedPaymentEntity) {
            payments.add(PaymentMapper.EntityToDto(paymentEntity));
        }
        logger.info("Get Payment Details filtered by paymentType");
        return ResponseEntity.ok().body(payments);
    }


}
