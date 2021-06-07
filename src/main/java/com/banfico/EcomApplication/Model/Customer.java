package com.banfico.EcomApplication.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String emailId;
    private String address;
    private String pinCode;
    private String phNo;
    @JsonManagedReference("customerRef")
    @OneToMany(targetEntity = OrderDetail.class,mappedBy = "customer",cascade = CascadeType.ALL)
    private List<OrderDetail> orders;

    public void customerOrders(OrderDetail orderdetail) {
       orders.add(orderdetail);
    }

}
