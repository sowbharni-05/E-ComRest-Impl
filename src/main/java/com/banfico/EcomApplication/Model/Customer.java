package com.banfico.EcomApplication.Model;

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
    private String CustomerName;
    private String emailId;
    private String address;
    private String pinCode;
    private int phNo;
    @OneToMany(targetEntity = Order.class)
    private List<Order> orders;

}
