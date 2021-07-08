package com.banfico.EcomApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;

    @JsonManagedReference
    @OneToMany(targetEntity = ProductEntity.class,
            mappedBy = "categoryDetails",
            cascade = CascadeType.ALL)
    private List<ProductEntity> products;

  /*  public Category(String categoryName) {
        this.categoryName=categoryName;
    }*/
}
