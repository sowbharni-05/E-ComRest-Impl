package com.banfico.EcomApplication.controller;
import com.banfico.EcomApplication.model.Category;
import com.banfico.EcomApplication.model.Product;
import com.banfico.EcomApplication.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Products",description = "Add, View, Update, Delete of Products and Categories")
@RestController
@RequestMapping("/categories")
public class ProductController {
    @Autowired
    private ProductService productservice;

    @ApiOperation(value = "PostCategoryDetails",nickname = "AddCategory",notes="Post Category Details")
    @RequestMapping(path = "/",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addCategory(@RequestBody Category category)
    {
        return productservice.addCategoryInfo(category);
    }

    @ApiOperation(value = "GetCategoryDetails",nickname = "GetCategoryInfo",notes = "View Category Details with its mapped Products")
    @RequestMapping(path="/",method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategory(){

        return productservice.getCategoryInfo();
    }

    @ApiOperation(value = "GetCategoryByName",nickname = "GetCategoryInfo",notes = "Provide a category name to look up a specific Category details")
    @RequestMapping(path="/name",method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategoryByname(@RequestParam(name = "name") String categoryName){
        return productservice.getCategoryByName(categoryName);
    }

    @ApiOperation(value ="DeleteCategoryById",nickname = "DeleteCategoryInfo",notes = "Provide an id to delete a specific Category")
    @RequestMapping(path = "/{id}",method= RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable int id){

        return productservice.deleteCategoryInfo(id);
    }

    @ApiOperation(value = "PostProductDetails",nickname = "AddProductInfo",notes = "Post Product with its mapped Category")
    @RequestMapping(path = "/products",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addProduct(@RequestBody Product productInfo)
    {
        return productservice.addProductInfo(productInfo);
    }

    @ApiOperation(value = "GetProductDetails",nickname = "GetProductInfo",notes = "View Product Details sorted ascending by price")
    @RequestMapping(path="/products",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductByAsc(){
        return productservice.getProductInfoSort();
    }

    @ApiOperation(value = "DeleteProductDetailById",nickname = "DeleteProductInfo",notes = "Provide an id to delete a specific product details")
    @RequestMapping(path = "/products/{id}",method= RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id){

        return productservice.deleteProductInfo(id);
    }


}
