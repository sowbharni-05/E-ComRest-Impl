package com.banfico.EcomApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="orderdetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderstatus;
    private int quantity;
    private boolean payStatus;
    @JsonFormat(pattern = "yyyy/mm/dd")
    private Date orderDate;
    @JsonBackReference(value = "shippingRef")
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Shipping.class)
    @JoinColumn(name = "shipId",referencedColumnName = "shippingId")
    private Shipping shipping;
    @JsonBackReference(value="customerRef")
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Customer.class)
    @JoinColumn(name="CusId",referencedColumnName = "customerId")
    private Customer customer;


}
