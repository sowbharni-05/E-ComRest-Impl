package com.banfico.EcomApplication.entity;

import com.banfico.EcomApplication.model.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="category")
public class CategoryEntity extends Category {

    private String categoryName;
    @JsonManagedReference
    @OneToMany(targetEntity = ProductEntity.class,
            mappedBy = "categoryDetails",
            cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProductEntity> products;

  /*  public Category(String categoryName) {
        this.categoryName=categoryName;
    }*/
}
