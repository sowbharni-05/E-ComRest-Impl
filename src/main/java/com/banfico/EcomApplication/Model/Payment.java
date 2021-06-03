package com.banfico.EcomApplication.Model;

import javax.persistence.*;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String payType;
    private double amt;
}
