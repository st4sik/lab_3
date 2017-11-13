package com.project.springboot.lab.service;

import com.project.springboot.lab.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(int productId);

    void addProduct(ProductEntity productEntity);

    void updateProduct(ProductEntity productEntity);

    void deleteProduct(int productId);
}
