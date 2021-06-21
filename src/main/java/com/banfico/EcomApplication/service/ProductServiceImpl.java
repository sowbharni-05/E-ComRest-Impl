package com.banfico.EcomApplication.service;

import com.banfico.EcomApplication.entity.CategoryEntity;
import com.banfico.EcomApplication.dao.CategoryRepo;
import com.banfico.EcomApplication.dao.ProductRepo;
import com.banfico.EcomApplication.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productrepo;

    @Autowired
    private CategoryRepo categoryrepo;
    @Override
    public ResponseEntity<HttpStatus> addCategoryInfo(CategoryEntity categoryEntityInfo) {
        CategoryEntity savedCategoryEntity = categoryrepo.save(categoryEntityInfo);
        if (categoryrepo.findById(savedCategoryEntity.getCategoryId()).isPresent())
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<List<CategoryEntity>> getCategoryInfo()
    {
        List<CategoryEntity> savedCategoryEntity =categoryrepo.findAll();
        return ResponseEntity.ok().body(savedCategoryEntity);

    }
    @Override
    public ResponseEntity<List<CategoryEntity>> getCategoryByName(String categoryName) {
        List<CategoryEntity> savedCategoryEntity =categoryrepo.findByCategoryName(categoryName);
        return ResponseEntity.ok().body(savedCategoryEntity);
    }
    @Override
    public ResponseEntity<HttpStatus> deleteCategoryInfo(int id) {
        if (categoryrepo.findById(id).isPresent()) {
            CategoryEntity deleteCategoryEntity = categoryrepo.getById(id);
            categoryrepo.delete(deleteCategoryEntity);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @Override
    public ResponseEntity<HttpStatus> addProductInfo(ProductEntity productinfo)
    {
        ProductEntity savedProductEntity = productrepo.save(productinfo);
        if (productrepo.findById(savedProductEntity.getProductId()).isPresent())
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<List<ProductEntity>> getProductInfoSort()
    {
        List<ProductEntity> productEntity =productrepo.findByOrderByPriceAsc();
        return ResponseEntity.ok().body(productEntity);
    }
    @Override
    public ResponseEntity<HttpStatus> deleteProductInfo(int id) {
        if (productrepo.findById(id).isPresent()) {
            ProductEntity deleteProductEntity = productrepo.getById(id);
            productrepo.delete(deleteProductEntity);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
