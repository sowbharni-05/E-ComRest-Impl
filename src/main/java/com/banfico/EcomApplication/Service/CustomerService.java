package com.banfico.EcomApplication.Service;

import com.banfico.EcomApplication.Dao.CustomerRepo;
import com.banfico.EcomApplication.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerrepo;

    private Customer savedCus;

    public ResponseEntity<String> addCustomerInfo(Customer cus) {
        savedCus=customerrepo.save(cus);
        if(customerrepo.findById(savedCus.getCustomerId()).isPresent())
            return ResponseEntity.ok().body("Customer Details Updated");
        return ResponseEntity.badRequest().body("Invalid Approach");
    }

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

    public ResponseEntity<String> updateCustomer(int id, String address) {
        savedCus = null;
        if (customerrepo.findById(id).isPresent()) {
            savedCus = customerrepo.getById(id);
            savedCus.setAddress(address);
            customerrepo.save(savedCus);
            return ResponseEntity.ok().body("Details updated successfully");
        }
        return ResponseEntity.unprocessableEntity().body("No details found");
    }

}