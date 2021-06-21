package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderstatus;
    @Positive(message = "Quantity cannot be negative")
    private int quantity;
    private boolean payStatus;
    @JsonFormat(pattern = "yyyy/mm/dd")
    private Date orderDate;
}
