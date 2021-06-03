package com.banfico.EcomApplication.Model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId",referencedColumnName ="categoryId")
    private Category category;

}
