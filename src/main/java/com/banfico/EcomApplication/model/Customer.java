package com.banfico.EcomApplication.model;
import com.banfico.EcomApplication.entity.Address;
import com.banfico.EcomApplication.entity.OrderDetailEntity;
import com.banfico.EcomApplication.validation.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import java.util.List;


@Accessors(chain = true)
@Setter
@Getter
@ApiModel(value = "Customer",description = "Customer Details with its mapped Orders")
@JsonPropertyOrder({"customerId","phNo","customerName","emailId","address","pinCode"})
public class Customer {
    @ApiModelProperty(name = "CustomerId",position = 1)
    private int customerId;
    @ApiModelProperty(name = "CustomerName",notes = "Name of the Customer")
    private String customerName;
    @ApiModelProperty(name="CustomerEmailId",example = "customername@gmail.com",position = 3,dataType = "String")
    @Email(message="Invalid EmailId")
    private String emailId;
   /* @ApiModelProperty(name="Address",position = 4,dataType = "String")
    @NotBlank(message = "Address should not be empty")
    private String address;*/
    @ApiModelProperty(name = "PhoneNumber",dataType = "String",position =4,hidden = true)
    //@Size(min = 0,max = 10,message = "Invalid PhoneNumber")
    @PhoneNumber(message = "PhoneNumber must be  valid" )
    private String phNo;
   /* @ApiModelProperty(name="Pincode")
    private String pinCode;*/
    private List<Address> addresses;
    private List<OrderDetailEntity> orderDetails;
}
