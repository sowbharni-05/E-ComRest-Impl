package com.banfico.EcomApplication.Controller;

import com.banfico.EcomApplication.Model.Product;
import com.banfico.EcomApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productservice;

    @RequestMapping(path = "/product",method = RequestMethod.POST)
    public  ResponseEntity<String> addProduct(@RequestBody Product productinfo)
    {

       return productservice.addProductInfo(productinfo);
    }

    @RequestMapping(path="/product",method = RequestMethod.GET)
    public ResponseEntity<Object> getCategory(){

        return productservice.getCategoryInfo();
    }
    @RequestMapping(path = "/product/{id}",method= RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(@PathVariable int id){

        return productservice.deleteProductInfo(id);
    }

}
