package com.banfico.EcomApplication.controller;

import com.banfico.EcomApplication.entity.CategoryEntity;
import com.banfico.EcomApplication.entity.ProductEntity;
import com.banfico.EcomApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ProductController {
    @Autowired
    private ProductService productservice;

    @RequestMapping(path = "/",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addCategory(@RequestBody CategoryEntity categoryEntityInfo)
    {

        return productservice.addCategoryInfo(categoryEntityInfo);
    }
    @RequestMapping(path="/",method = RequestMethod.GET)
    public ResponseEntity<List<CategoryEntity>> getCategory(){

        return productservice.getCategoryInfo();
    }
    @RequestMapping(path="/name",method = RequestMethod.GET)
    public ResponseEntity<List<CategoryEntity>> getCategoryByname(@RequestParam(name = "name") String categoryName){
        return productservice.getCategoryByName(categoryName);
    }


    @RequestMapping(path = "/{id}",method= RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable int id){

        return productservice.deleteCategoryInfo(id);
    }
    @RequestMapping(path = "/products",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addProduct(@RequestBody ProductEntity productEntityInfo)
    {

        return productservice.addProductInfo(productEntityInfo);
    }
    @RequestMapping(path="/products",method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getProductByAsc(){
        return productservice.getProductInfoSort();
    }

    @RequestMapping(path = "/products/{id}",method= RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id){

        return productservice.deleteProductInfo(id);
    }


}
