package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.entity.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Setter
@Getter
@Accessors(chain = true)
@ApiModel(value = "Product",description = "Products with its Category Details")
public class Product {

    private int productId;
    @ApiModelProperty(name = "ProductName")
    private String productName;
    @ApiModelProperty(name = "ProductPrice",value = "0.00")
    private double price;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CategoryEntity categoryDetails;
}
