package com.project.springboot.lab.service.impl;

import com.project.springboot.lab.entity.CustomerEntity;
import com.project.springboot.lab.jpa.CustomerRepository;
import com.project.springboot.lab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public CustomerEntity getCustomerById(int customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public void addCustomer(CustomerEntity customerEntity) {
        customerRepository.addCustomer(customerEntity);

    }

    @Override
    public void updateCustomer(CustomerEntity customerEntity) {
        customerRepository.updateCustomer(customerEntity);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteCustomer(customerId);
    }
}
