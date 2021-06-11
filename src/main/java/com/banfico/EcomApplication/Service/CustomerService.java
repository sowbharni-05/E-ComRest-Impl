package com.banfico.EcomApplication.Service;

import com.banfico.EcomApplication.Dao.CustomerRepo;
import com.banfico.EcomApplication.Dao.OrderRepo;
import com.banfico.EcomApplication.Dao.PaymentRepo;
import com.banfico.EcomApplication.Dao.ShippingRepo;
import com.banfico.EcomApplication.Exception.DataNotValidException;
import com.banfico.EcomApplication.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerrepo;
    @Autowired private OrderRepo orderrepo;
    @Autowired private ShippingRepo shippingrepo;
    @Autowired private PaymentRepo paymentrepo;

    private Customer savedCus;
    private OrderDetail savedOrder;


    public ResponseEntity<Object> getCustomerInfo() {
        List<Customer> savedCus=customerrepo.findAll();
        if(savedCus.isEmpty())
            return ResponseEntity.badRequest().body("There is no Customer details to display");
        return ResponseEntity.ok().body(savedCus);

    }
    public ResponseEntity<String> deleteCustomerInfo(int id){
        if(customerrepo.findById(id).isPresent()){
            Customer deleteCustomer=customerrepo.getById(id);
            customerrepo.delete(deleteCustomer);
            return ResponseEntity.ok().body("Details Deleted Successfully");
        }
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

    public ResponseEntity<String> updateCustomer(int id, String address, String phno) {
        savedCus = null;
        try{
        if (customerrepo.findById(id).isPresent()) {
            savedCus = customerrepo.getById(id);
            savedCus.setAddress(address);
            savedCus.setPhNo(phno);
            customerrepo.save(savedCus);
            return ResponseEntity.ok().body("Details Updated Successfully");
        }
            return ResponseEntity.unprocessableEntity().body("No Records Found");}

        catch (Exception e){
            throw new DataNotValidException();
        }

    }
    public ResponseEntity<String> addOrderInfo(OrderDetail ord) {
        try {
           savedOrder = orderrepo.save(ord);
           if (orderrepo.findById(savedOrder.getOrderId()).isPresent())
               return ResponseEntity.ok().body("OrderDetails Recorded");
           return ResponseEntity.badRequest().body("Invalid Approach");
       }
       catch (Exception e)
       {
           throw new DataNotValidException();
       }
    }


    public ResponseEntity<String> deleteOrderInfo(int id) {
        if (orderrepo.findById(id).isPresent()) {
            OrderDetail deleteOrder = orderrepo.getById(id);
            orderrepo.delete(deleteOrder);
            return ResponseEntity.ok().body("Details Deleted Successfully");
        }
        return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

    public ResponseEntity<String> updateStatus(int id, OrderStatus status) {
        savedOrder = null;
        if (orderrepo.findById(id).isPresent()) {
            savedOrder = orderrepo.getById(id);
            savedOrder.setOrderstatus(status);
            orderrepo.save(savedOrder);
            return ResponseEntity.ok().body("OrderStatus Updated Successfully");
        }
        return ResponseEntity.unprocessableEntity().body("No Records Found");
    }
    public ResponseEntity<Object> getOrderDetail()
    {
        List<OrderDetail> orderdetail =orderrepo.findByOrderByOrderDateAsc();
        if(orderdetail.isEmpty())
            return ResponseEntity.badRequest().body("No Records Found");
        return ResponseEntity.ok().body(orderdetail);
    }

    public ResponseEntity<Object> getShippingInfo()
    {
        List<Shipping> savedshipping=shippingrepo.findAll();
        if(savedshipping.isEmpty())
            return ResponseEntity.badRequest().body("No Records Found");
        return ResponseEntity.ok().body(savedshipping);
    }

    public ResponseEntity<Object> getPaymentInfo()
    {
        List<Payment> savedpayment =paymentrepo.findAll();
        if(savedpayment.isEmpty())
            return ResponseEntity.badRequest().body("No Records Found");
        return ResponseEntity.ok().body(savedpayment);
    }

    public ResponseEntity<Object> getPaymentTypeInfo(String pType)
    {
        List<Payment> savedpayment =paymentrepo.getBypayTypeMatch(pType);
        if(savedpayment.isEmpty())
            return ResponseEntity.badRequest().body("No Records Matched");
        return ResponseEntity.ok().body(savedpayment);
    }
}
