package com.banfico.EcomApplication.Service;

import com.banfico.EcomApplication.Dao.CustomerRepo;
import com.banfico.EcomApplication.Dao.OrderRepo;
import com.banfico.EcomApplication.Dao.ShippingRepo;
import com.banfico.EcomApplication.Model.Customer;
import com.banfico.EcomApplication.Model.OrderDetail;
import com.banfico.EcomApplication.Model.OrderStatus;
import com.banfico.EcomApplication.Model.Shipping;
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

    private Customer savedCus;
    private OrderDetail savedOrder;


    public ResponseEntity<Object> getCustomerInfo() {
        List<Customer> savedCus=customerrepo.findAll();
        if(savedCus.isEmpty())
            return ResponseEntity.badRequest().body("No records found");
        return ResponseEntity.ok().body(savedCus);

    }
    public ResponseEntity<String> deleteCustomerInfo(int id){
        if(customerrepo.findById(id).isPresent()){
            Customer deleteCustomer=customerrepo.getById(id);
            customerrepo.delete(deleteCustomer);
            return ResponseEntity.ok().body("Details deleted successfully");
        }
            return ResponseEntity.unprocessableEntity().body("No details found");
    }

    public ResponseEntity<String> updateCustomer(int id, String address, String phno) {
        savedCus = null;
        if (customerrepo.findById(id).isPresent()) {
            savedCus = customerrepo.getById(id);
            savedCus.setAddress(address);
            savedCus.setPhNo(phno);
            customerrepo.save(savedCus);
            return ResponseEntity.ok().body("Details updated successfully");
        }
        return ResponseEntity.unprocessableEntity().body("No details found");
    }
    public ResponseEntity<String> addOrderInfo(OrderDetail ord) {
        savedOrder = orderrepo.save(ord);
        if (orderrepo.findById(savedOrder.getOrderId()).isPresent())
            return ResponseEntity.ok().body("Details Recorded");
        return ResponseEntity.badRequest().body("Invalid Approach");
    }


    public ResponseEntity<String> deleteOrderInfo(int id) {
        if (orderrepo.findById(id).isPresent()) {
            OrderDetail deleteOrder = orderrepo.getById(id);
            orderrepo.delete(deleteOrder);
            return ResponseEntity.ok().body("Details deleted successfully");
        }
        return ResponseEntity.unprocessableEntity().body("No details found");
    }

    public ResponseEntity<String> updateStatus(int id, OrderStatus status) {
        savedOrder = null;
        if (orderrepo.findById(id).isPresent()) {
            savedOrder = orderrepo.getById(id);
            savedOrder.setOrderstatus(status);
            orderrepo.save(savedOrder);
            return ResponseEntity.ok().body("Details updated successfully");
        }
        return ResponseEntity.unprocessableEntity().body("No details found");
    }
    public ResponseEntity<Object> getShippingInfo()
    {
        List<Shipping> savedshipping=shippingrepo.findAll();
        if(savedshipping.isEmpty())
            return ResponseEntity.badRequest().body("No records found");
        return ResponseEntity.ok().body(savedshipping);
    }

}
