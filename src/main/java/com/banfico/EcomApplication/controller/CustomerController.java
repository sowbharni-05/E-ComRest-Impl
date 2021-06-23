package com.banfico.EcomApplication.controller;

import com.banfico.EcomApplication.entity.*;
import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.banfico.EcomApplication.model.Customer;
import com.banfico.EcomApplication.model.OrderDetail;
import com.banfico.EcomApplication.model.Payment;
import com.banfico.EcomApplication.model.Shipping;
import com.banfico.EcomApplication.service.CustomerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController{
    @Autowired
    private CustomerService customerservice;

    @ApiOperation(nickname = "GetCustomerInfo",value = "GetCustomerDetails",notes = "View Customer Details with its mapped Orders")
    @RequestMapping(path="/",method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomer(){

        return customerservice.getCustomerInfo();
    }

    @ApiOperation(nickname = "AddCustomerInfo",value = "PostCustomerDetails",notes = "Post Customer Details")
    @RequestMapping(path = "/",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addCustomer(@Valid @RequestBody Customer customer){
        return customerservice.addCustomerInfo(customer);
    }

    @ApiOperation(nickname = "UpdateCustomerInfo",value = "UpdateCustomerDetails",notes = "Provide an id to update address,phone number of a specific Customer")
    @RequestMapping(path="/", method = RequestMethod.PATCH)
    public ResponseEntity<CustomerEntity> updateCustomer(@Valid @RequestParam int id, @RequestParam String address, @RequestParam String phno){
        return customerservice.updateCustomer(id,address,phno);

    }

    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 400, message = "BadRequest")})
    @ApiOperation(value = "DeleteCustomerById",notes = "Provide an id to delete an specific customer",
            response =CustomerEntity.class,nickname = "DeleteCustomer")
    @RequestMapping(path="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCustomer(@ApiParam(name = "CustomerId",defaultValue = "0") @PathVariable int id){
        return customerservice.deleteCustomerInfo(id);
    }

    @ApiOperation(nickname = "AddOrderInfo",value = "PostOrderDetails",notes = "Post Order Details with its mapped Customer")
    @RequestMapping(path="/orders",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addOrder(@RequestBody OrderDetail order)
    {
        return customerservice.addOrderInfo(order);
    }

    @ApiOperation(value = "UpdateOrderStatus",nickname = "UpdateOrderInfo",
            notes = "Provide an id to update OrderStatus of a specific Order details")
    @RequestMapping(path="/orders", method = RequestMethod.PUT)
    public ResponseEntity<OrderDetailEntity> updateStatus(@RequestParam(value = "id") int id, @RequestParam(value = "status") OrderStatus status){
        return customerservice.updateStatus(id,status);
    }

    @ApiOperation(value = "DeleteOrderDetailsById",nickname = "DeleteOrderInfo",notes = "Provide an id to delete specific Order")
    @RequestMapping(path="/orders",method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteOrder(@PathParam(value = "id") int id){
        return customerservice.deleteOrderInfo(id);
    }

    @ApiOperation(value = "GetOrderDetails",nickname = "GetOrderInfo",notes = "View order details")
    @RequestMapping(path="/orders",method = RequestMethod.GET)
    public ResponseEntity<List<OrderDetail>> getOrderdetail(){
        return customerservice.getOrderDetail();
    }

    @ApiOperation(value = "GetShippingDetails",nickname = "GetShippingInfo",notes = "View Shipping details with its Orders")
    @RequestMapping(path="/orders/shipping",method = RequestMethod.GET)
    public ResponseEntity<List<Shipping>> getShipping()
    {
        return customerservice.getShippingInfo();
    }

    @ApiOperation(value = "GetPaymentDetails",nickname = "GetPaymentInfo",notes = "View Order's Payment details")
    @RequestMapping(path="/orders/payment",method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getPayment()
    {
        return customerservice.getPaymentInfo();
    }

    @ApiOperation(value = "GetPaymentDetailsByPayType",nickname = "GetPaymentInfo",notes = "Provide an payment type to get specific Payment type details")
    @RequestMapping(path = "/orders/payment/{payType}",method=RequestMethod.GET)
    public ResponseEntity<List<Payment>> getPaymentType(@PathParam("payType") String pType){
        return customerservice.getPaymentTypeInfo(pType);
    }


}
