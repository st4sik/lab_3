package com.project.springboot.lab.service.impl;

import com.project.springboot.lab.entity.ProductEntity;
import com.project.springboot.lab.jpa.ProductRepository;
import com.project.springboot.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public ProductEntity getProductById(int productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        productRepository.addProduct(productEntity);
    }

    @Override
    public void updateProduct(ProductEntity productEntity) {
        productRepository.updateProduct(productEntity);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteProduct(productId);
    }
}
