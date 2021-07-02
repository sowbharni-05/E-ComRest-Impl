package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.entity.CustomerEntity;
import com.banfico.EcomApplication.entity.PaymentEntity;
import com.banfico.EcomApplication.entity.ShippingEntity;
import com.banfico.EcomApplication.entity.enumtype.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "OrderDetail",description = "OrderDetails with its mapped Shipping and Payment Information")
@JsonPropertyOrder(alphabetic = true)
public class OrderDetail {

    private int orderId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderstatus;
    @Positive(message = "Quantity cannot be negative")
    private int quantity;
    private boolean payStatus;
    @ApiModelProperty(name="OrderDate",notes = "OrderedDate")
    @JsonFormat(pattern = "yyyy/mm/dd",shape = JsonFormat.Shape.STRING)
    private Date orderDate;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PaymentEntity paymentDetails;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ShippingEntity shippingDetails;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CustomerEntity customerDetails;

}
