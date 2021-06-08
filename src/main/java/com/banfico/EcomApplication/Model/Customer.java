package com.banfico.EcomApplication.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @Email(message="Invalid EmailId")
    private String emailId;
    @NotBlank(message = "Address should not be empty")
    private String address;
    private String pinCode;
    @Size(min = 0,max = 10,message = "Invalid PhoneNumber")
    private String phNo;
    @JsonManagedReference("customerRef")
    @OneToMany(targetEntity = OrderDetail.class,mappedBy = "customer",cascade = CascadeType.ALL)
    private List<OrderDetail> orders;

    public void customerOrders(OrderDetail orderdetail) {

        orders.add(orderdetail);
    }

}
