package com.project.springboot.lab.jpa.impl;

import com.project.springboot.lab.entity.CustomerEntity;
import com.project.springboot.lab.entity.ProductEntity;
import com.project.springboot.lab.jpa.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ProductJpaImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductEntity> getAllProducts() {
        return entityManager.createNamedQuery(ProductEntity.QUERY_ALL, ProductEntity.class).getResultList();
    }

    @Override
    public ProductEntity getProductById(int productId) {
        return (ProductEntity) entityManager.createQuery(ProductEntity.QUERY_BY_PRODUCT_ID, CustomerEntity.class)
                .setParameter(ProductEntity.PARAM_PRODUCT_ID, productId);
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        entityManager.persist(productEntity);
    }

    @Override
    public void updateProduct(ProductEntity productEntity) {
        ProductEntity product = new ProductEntity();
        product.setName(productEntity.getName());
        entityManager.flush();
    }

    @Override
    public void deleteProduct(int productId) {
        entityManager.remove(getProductById(productId));
    }
}
