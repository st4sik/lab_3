package com.project.springboot.lab.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_table")
@NamedQueries({
        @NamedQuery(name = CustomerEntity.QUERY_ALL, query = "SELECT c FROM CustomerEntity c"),
        @NamedQuery(name = CustomerEntity.QUERY_BY_CUSTOMER_ID, query = "select c from CustomerEntity c where c.id = :" + CustomerEntity.PARAM_CUSTOMER_ID)
})
public class CustomerEntity {

    public static final String QUERY_ALL = "CustomerEntity.findAll";
    public static final String QUERY_BY_CUSTOMER_ID = "CustomerEntity.getCustomerById";
    public static final String PARAM_CUSTOMER_ID = "customerId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private String mobile;
    @Column
    private String address;

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getAddress() {
        return this.address;
    }


}
