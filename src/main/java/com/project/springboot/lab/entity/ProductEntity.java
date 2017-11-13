package com.project.springboot.lab.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_table")
@NamedQueries({
        @NamedQuery(name = ProductEntity.QUERY_ALL, query = "SELECT p FROM ProductEntity p"),
        @NamedQuery(name = ProductEntity.QUERY_BY_PRODUCT_ID, query = "select p from ProductEntity p where p.id = :" + ProductEntity.PARAM_PRODUCT_ID)
})
public class ProductEntity {
    public static final String QUERY_ALL = "ProductEntity.findAll";
    public static final String QUERY_BY_PRODUCT_ID = "ProductEntity.findProductById";
    public static final String PARAM_PRODUCT_ID = "productId";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
