package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.entity.OrderDetailEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Getter
@Setter
@ApiModel(value = "Payment",description = "Payment details of the Customer Orders")
public class Payment {

    private int paymentId;
    @ApiModelProperty(name = "PaymentType",example = "CashOnDelivery")
    private String payType;

    private OrderDetailEntity orderDetails;
}
