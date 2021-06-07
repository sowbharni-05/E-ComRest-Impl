package com.banfico.EcomApplication.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shippingId;
    private String shippingType;
    private int ShippingCost;
   // @JsonManagedReference(value="shippingRef")
    @OneToOne(cascade = CascadeType.ALL,targetEntity = OrderDetail.class,mappedBy = "shipping")
    private OrderDetail orderdetail;

}
