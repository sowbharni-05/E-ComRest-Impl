package com.banfico.EcomApplication.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name="customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String emailId;
    private String address;
    private String phNo;
    private String pinCode;

    @JsonManagedReference("customerRef")
    @OneToMany(targetEntity = OrderDetailEntity.class,
            mappedBy = "customerDetails",cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderDetailEntity> orderDetails;

}
