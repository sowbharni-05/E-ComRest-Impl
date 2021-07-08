package com.banfico.EcomApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
@Accessors(chain = true)
public class Address {
    private String addressLine;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
