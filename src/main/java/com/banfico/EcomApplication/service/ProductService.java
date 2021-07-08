package com.banfico.EcomApplication.service;
import com.banfico.EcomApplication.model.Category;
import com.banfico.EcomApplication.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<HttpStatus> addCategoryInfo(Category categoryInfo);
    ResponseEntity<List<Category>> getCategoryInfo();
    ResponseEntity<List<Category>> getCategoryByName(String categoryName);
    ResponseEntity<HttpStatus> deleteCategoryInfo(int id);
    ResponseEntity<HttpStatus> addProductInfo(Product productInfo);
    ResponseEntity<List<Product>> getProductInfoSort();
    ResponseEntity<HttpStatus> deleteProductInfo(int id);

}
