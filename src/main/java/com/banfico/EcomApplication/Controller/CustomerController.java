package com.banfico.EcomApplication.Controller;

import com.banfico.EcomApplication.Model.Customer;
import com.banfico.EcomApplication.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController{
    @Autowired
    private CustomerService customerservice;

    @RequestMapping(path = "/customer",method = RequestMethod.POST)

    public ResponseEntity<String> addCustomer(@RequestBody Customer cus)
    {
        return customerservice.addCustomerInfo(cus);
    }
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

}
