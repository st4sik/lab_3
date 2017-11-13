package com.project.springboot.lab.jpa.impl;

import com.project.springboot.lab.entity.CustomerEntity;
import com.project.springboot.lab.jpa.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CustomerJpaImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return entityManager.createNamedQuery(CustomerEntity.QUERY_ALL, CustomerEntity.class).getResultList();
    }

    @Override
    public CustomerEntity getCustomerById(int customerId) {
        return (CustomerEntity) entityManager.createQuery(CustomerEntity.QUERY_BY_CUSTOMER_ID, CustomerEntity.class)
                .setParameter(CustomerEntity.PARAM_CUSTOMER_ID, customerId);
    }

    @Override
    public void addCustomer(CustomerEntity customerEntity) {
        entityManager.persist(customerEntity);
    }

    @Override
    public void updateCustomer(CustomerEntity customerEntity) {
        CustomerEntity customer = getCustomerById(customerEntity.getId());
        customer.setAddress(customerEntity.getAddress());
        customer.setMobile(customer.getMobile());
        customer.setName(customer.getName());
        entityManager.flush();
    }

    @Override
    public void deleteCustomer(int customerId) {
        entityManager.remove(getCustomerById(customerId));
    }
}
