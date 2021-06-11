package com.banfico.EcomApplication.Controller;

import com.banfico.EcomApplication.Model.OrderDetail;
import com.banfico.EcomApplication.Model.OrderStatus;
import com.banfico.EcomApplication.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;


@RestController
public class CustomerController{
    @Autowired
    private CustomerService customerservice;

    @RequestMapping(path="/customer",method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomer(){

        return customerservice.getCustomerInfo();
    }
    @RequestMapping(path="/customer/{id}/{address}/{phno}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateCustomer(@Valid @PathVariable int id, @PathVariable String address, @PathVariable String phno){
            return customerservice.updateCustomer(id,address,phno);

    }
    @RequestMapping(path="/customer/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        return customerservice.deleteCustomerInfo(id);
    }
    @RequestMapping(path="/order",method = RequestMethod.POST)
   public ResponseEntity<String> addOrder(@Valid @RequestBody OrderDetail order)
    {
        return customerservice.addOrderInfo(order);
    }
    @RequestMapping(path="/order", method = RequestMethod.PUT)
    public ResponseEntity<String> updateStatus(@RequestParam(value = "id") int id, @RequestParam(value = "status") OrderStatus status){
        return customerservice.updateStatus(id,status);
    }
    @RequestMapping(path="/order",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(@PathParam(value = "id") int id){
        return customerservice.deleteOrderInfo(id);
    }
    @RequestMapping(path="/order",method = RequestMethod.GET)
    public ResponseEntity<Object> getOrderdetail(){
        return customerservice.getOrderDetail();
    }
    @RequestMapping(path="/shipping",method = RequestMethod.GET)
    public ResponseEntity<Object> getShipping()
    {
        return customerservice.getShippingInfo();
    }

    @RequestMapping(path="/payment",method = RequestMethod.GET)
    public ResponseEntity<Object> getPayment()
    {
        return customerservice.getPaymentInfo();
    }
    @RequestMapping(path = "/payment/{payType}",method=RequestMethod.GET)
    public ResponseEntity<Object> getPaymentType(@PathVariable("payType") String pType){
        return customerservice.getPaymentTypeInfo(pType);
    }


}
