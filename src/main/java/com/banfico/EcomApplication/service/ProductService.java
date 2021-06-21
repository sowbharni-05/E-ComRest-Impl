package com.banfico.EcomApplication.service;

import com.banfico.EcomApplication.entity.CategoryEntity;
import com.banfico.EcomApplication.entity.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public ResponseEntity<HttpStatus> addCategoryInfo(CategoryEntity categoryEntityInfo);
    public ResponseEntity<List<CategoryEntity>> getCategoryInfo();
    public ResponseEntity<List<CategoryEntity>> getCategoryByName(String categoryName);
    public ResponseEntity<HttpStatus> deleteCategoryInfo(int id);
    public ResponseEntity<HttpStatus> addProductInfo(ProductEntity productinfo);
    public ResponseEntity<List<ProductEntity>> getProductInfoSort();
    public ResponseEntity<HttpStatus> deleteProductInfo(int id);

}
