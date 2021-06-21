package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity extends Product {

    private String productName;
    private double price;
    @JsonBackReference
    @ManyToOne(targetEntity = CategoryEntity.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",referencedColumnName ="categoryId")
    private CategoryEntity categoryDetails;

  /*  public ProductEntity(String productName, double price, CategoryEntity categoryEntity) {
        this.productName = productName;
        this.price = price;
        this.categoryEntity = categoryEntity;
    }*/
}
