package com.banfico.EcomApplication.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String orderStatus;
    private int quantity;
    private boolean payStatus;
    @JsonFormat(pattern = "yyyy/mm/dd")
    private Date orderDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipId",referencedColumnName = "shippingId")
    private Shipping shipping;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CusId",referencedColumnName = "customerId")
    private Customer customer;


}
