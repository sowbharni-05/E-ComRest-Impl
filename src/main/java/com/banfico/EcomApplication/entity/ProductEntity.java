package com.banfico.EcomApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private double price;

   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
