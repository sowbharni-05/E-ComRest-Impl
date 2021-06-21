package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.validation.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @Email(message="Invalid EmailId")
    private String emailId;
    @NotBlank(message = "Address should not be empty")
    private String address;
    //@Size(min = 0,max = 10,message = "Invalid PhoneNumber")
    @PhoneNumber(message = "PhoneNumber must be  valid" )
    private String phNo;
}
