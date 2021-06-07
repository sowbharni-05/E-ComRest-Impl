package com.banfico.EcomApplication.Service;

import com.banfico.EcomApplication.Dao.CategoryRepo;
import com.banfico.EcomApplication.Dao.ProductRepo;
import com.banfico.EcomApplication.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productrepo;
    @Autowired
    private CategoryRepo categoryrepo;
    private Product savedProduct;

   public ResponseEntity<String> addProductInfo(Product productinfo)
    {
        savedProduct = productrepo.save(productinfo);
        if (productrepo.findById(savedProduct.getProductId()).isPresent())
            return ResponseEntity.ok().body("Details Recorded");
        return ResponseEntity.badRequest().body("Invalid Approach");
    }
    public ResponseEntity<Object> getCategoryInfo()
    {
        List<Category> savedCategory=categoryrepo.findAll();
        if(savedCategory.isEmpty())
            return ResponseEntity.badRequest().body("No records found");
        return ResponseEntity.ok().body(savedCategory);

    }
    public ResponseEntity<String> deleteProductInfo(int id) {
        if (productrepo.findById(id).isPresent()) {
            Product deleteProduct = productrepo.getById(id);
            productrepo.delete(deleteProduct);
            return ResponseEntity.ok().body("Details deleted successfully");
        }
        return ResponseEntity.unprocessableEntity().body("No details found");
    }
}
