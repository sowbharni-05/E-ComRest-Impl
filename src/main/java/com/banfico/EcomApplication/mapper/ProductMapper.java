package com.banfico.EcomApplication.mapper;

import com.banfico.EcomApplication.entity.ProductEntity;
import com.banfico.EcomApplication.model.Product;

public class ProductMapper {
    public static ProductEntity DtoToEntity(Product prd) {
        return new ProductEntity().setProductName(prd.getProductName())
                .setPrice(prd.getPrice())
                .setCategoryDetails(prd.getCategoryDetails());
    }
    public static Product EntityToDto(ProductEntity prd) {
        return new Product().setProductId(prd.getProductId())
                .setProductName(prd.getProductName())
                .setPrice(prd.getPrice())
                .setCategoryDetails(prd.getCategoryDetails());
    }
}
