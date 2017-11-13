package com.project.springboot.lab.jpa;

import com.project.springboot.lab.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepository {
    List<CustomerEntity> getAllCustomers();

    CustomerEntity getCustomerById(int customerId);

    void addCustomer(CustomerEntity customerEntity);

    void updateCustomer(CustomerEntity customerEntity);

    void deleteCustomer(int customerId);
}
