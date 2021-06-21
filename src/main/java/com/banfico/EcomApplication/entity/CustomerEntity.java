package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.model.Customer;
import com.banfico.EcomApplication.validation.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="customer")
public class CustomerEntity extends Customer {

    private String customerName;
    private String pinCode;

    @JsonManagedReference("customerRef")
    @OneToMany(targetEntity = OrderDetailEntity.class,
            mappedBy = "customerDetails",cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderDetailEntity> orderDetails;

}
