package com.banfico.EcomApplication.service;

import com.banfico.EcomApplication.entity.CategoryEntity;
import com.banfico.EcomApplication.dao.CategoryRepo;
import com.banfico.EcomApplication.dao.ProductRepo;
import com.banfico.EcomApplication.entity.ProductEntity;
import com.banfico.EcomApplication.exception.DataNotValidException;
import com.banfico.EcomApplication.mapper.CategoryMapper;
import com.banfico.EcomApplication.mapper.ProductMapper;
import com.banfico.EcomApplication.model.Category;
import com.banfico.EcomApplication.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productrepo;

    @Autowired
    private CategoryRepo categoryrepo;
    @Override
    public ResponseEntity<HttpStatus> addCategoryInfo(Category categoryInfo) {
        CategoryEntity categoryEntity= CategoryMapper.DtoToEntity(categoryInfo);
        try{
            CategoryEntity savedCategoryEntity = categoryrepo.save(categoryEntity);
            if (categoryrepo.findById(savedCategoryEntity.getCategoryId()).isPresent())
                return new ResponseEntity<>(HttpStatus.CREATED);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e)
        {
            throw new DataNotValidException(e);
        }

    }
    @Override
    public ResponseEntity<List<Category>> getCategoryInfo()
    {
        List<CategoryEntity> savedCategoryEntity=categoryrepo.findAll();
        List<Category> categories=new ArrayList<>();
        for (CategoryEntity categoryEntity : savedCategoryEntity) {
            categories= Arrays.asList(CategoryMapper.EntityToDto(categoryEntity));
        }
        return ResponseEntity.ok().body(categories);
    }
    @Override
    public ResponseEntity<List<Category>> getCategoryByName(String categoryName) {
        List<CategoryEntity> savedCategoryEntity=categoryrepo.findByCategoryName(categoryName);
        List<Category> categories=new ArrayList<>();
        for (CategoryEntity categoryEntity : savedCategoryEntity) {
            categories= Arrays.asList(CategoryMapper.EntityToDto(categoryEntity));
        }
        return ResponseEntity.ok().body(categories);
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
    public ResponseEntity<HttpStatus> addProductInfo(Product productInfo)
    {
        ProductEntity productEntity= ProductMapper.DtoToEntity(productInfo);
        try{
            ProductEntity savedProductEntity = productrepo.save(productEntity);
            if (productrepo.findById(savedProductEntity.getProductId()).isPresent())
                return new ResponseEntity<>(HttpStatus.CREATED);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e)
        {
            throw new DataNotValidException(e);
        }

    }
    @Override
    public ResponseEntity<List<Product>> getProductInfoSort()
    {
        List<ProductEntity> savedProductEntity =productrepo.findByOrderByPriceAsc();
        List<Product> products= new ArrayList<>();
        for (ProductEntity productEntity : savedProductEntity) {
            products=Arrays.asList(ProductMapper.EntityToDto(productEntity));
        }
        return ResponseEntity.ok().body(products);
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
