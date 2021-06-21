package com.banfico.EcomApplication.controller;

import com.banfico.EcomApplication.entity.*;
import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.banfico.EcomApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController{
    @Autowired
    private CustomerService customerservice;

    @RequestMapping(path="/",method = RequestMethod.GET)
    public ResponseEntity<List<CustomerEntity>> getCustomer(){

        return customerservice.getCustomerInfo();
    }
    @RequestMapping(path = "/",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addCustomer(@RequestBody CustomerEntity customerEntity){
        return customerservice.addCustomerInfo(customerEntity);
    }
    @RequestMapping(path="/", method = RequestMethod.PATCH)
    public ResponseEntity<CustomerEntity> updateCustomer(@Valid @RequestParam int id, @RequestParam String address, @RequestParam String phno){
        return customerservice.updateCustomer(id,address,phno);

    }
    @RequestMapping(path="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable int id){
        return customerservice.deleteCustomerInfo(id);
    }
    @RequestMapping(path="/orders",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addOrder(@RequestBody OrderDetailEntity order)
    {
        return customerservice.addOrderInfo(order);
    }
    @RequestMapping(path="/orders", method = RequestMethod.PUT)
    public ResponseEntity<OrderDetailEntity> updateStatus(@RequestParam(value = "id") int id, @RequestParam(value = "status") OrderStatus status){
        return customerservice.updateStatus(id,status);
    }
    @RequestMapping(path="/orders",method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteOrder(@PathParam(value = "id") int id){
        return customerservice.deleteOrderInfo(id);
    }
    @RequestMapping(path="/orders",method = RequestMethod.GET)
    public ResponseEntity<List<OrderDetailEntity>> getOrderdetail(){
        return customerservice.getOrderDetail();
    }
    @RequestMapping(path="/orders/shipping",method = RequestMethod.GET)
    public ResponseEntity<List<ShippingEntity>> getShipping()
    {
        return customerservice.getShippingInfo();
    }

    @RequestMapping(path="/orders/payment",method = RequestMethod.GET)
    public ResponseEntity<List<PaymentEntity>> getPayment()
    {
        return customerservice.getPaymentInfo();
    }
    @RequestMapping(path = "/orders/payment/{payType}",method=RequestMethod.GET)
    public ResponseEntity<List<PaymentEntity>> getPaymentType(@PathParam("payType") String pType){
        return customerservice.getPaymentTypeInfo(pType);
    }


}
