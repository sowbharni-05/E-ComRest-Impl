package com.banfico.EcomApplication.model;

import com.banfico.EcomApplication.entity.ProductEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Category",description = "Category Details with its mapped Products")
public class Category {

    private int categoryId;
    @ApiModelProperty(name = "CategoryName",dataType = "String",example = "Accessories",value = "CategoryName")
    private String categoryName;
    private List<ProductEntity> products;
}
