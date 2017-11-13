package com.project.springboot.lab.controller;

import com.project.springboot.lab.entity.ProductEntity;
import com.project.springboot.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("product/{id}")
    public ResponseEntity<ProductEntity> getProdcutById(@PathVariable("id") Integer id) {
        ProductEntity product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("products")
    public ResponseEntity<List<ProductEntity>> getProducts(@PathVariable("id") Integer id) {
        List<ProductEntity> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PostMapping("product")
    public ResponseEntity<Void> addProduct(ProductEntity product) {
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
