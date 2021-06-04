package com.banfico.EcomApplication.Controller;

import com.banfico.EcomApplication.Model.Customer;
import com.banfico.EcomApplication.Model.OrderDetail;
import com.banfico.EcomApplication.Service.CustomerService;
import com.banfico.EcomApplication.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OrderController {

        @Autowired
        private OrderService orderservice;

        @RequestMapping(path = "/order",method = RequestMethod.POST)
        public void addOrder(@RequestBody OrderDetail orderdet)
        {
            orderservice.addOrderInfo(orderdet);
        }
        @RequestMapping(path="/order",method = RequestMethod.GET)
        public List<OrderDetail> getOrder(){
            return orderservice.getOrderInfo();
        }
}
