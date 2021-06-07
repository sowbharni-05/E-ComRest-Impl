package com.banfico.EcomApplication.Controller;

import com.banfico.EcomApplication.Model.OrderDetail;
import com.banfico.EcomApplication.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController{
    @Autowired
    private CustomerService customerservice;

    @RequestMapping(path="/customer",method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomer(){

        return customerservice.getCustomerInfo();
    }
    @RequestMapping(path="/customer/{id}/{address}", method = RequestMethod.POST)
    public ResponseEntity<String> updateCustomer(@PathVariable int id, @PathVariable String address){
        return customerservice.updateCustomer(id,address);
    }
    @RequestMapping(path="/customer/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        return customerservice.deleteCustomerInfo(id);
    }
    @RequestMapping(path="/order",method = RequestMethod.POST)
   public ResponseEntity<String> addOrder(@RequestBody OrderDetail order)
    {
        return customerservice.addOrderInfo(order);
    }
    @RequestMapping(path="/order/{id}/{status}", method = RequestMethod.POST)
    public ResponseEntity<String> updateStatus(@PathVariable int id, @PathVariable String status){
        return customerservice.updateStatus(id,status);
    }
    @RequestMapping(path="/order/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(@PathVariable int id){
        return customerservice.deleteOrderInfo(id);
    }
    @RequestMapping(path="/shipping",method = RequestMethod.GET)
    public ResponseEntity<Object> getShipping()
    {
        return customerservice.getShippingInfo();
    }


}
