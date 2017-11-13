package com.project.springboot.lab.controller;

import com.project.springboot.lab.entity.CustomerEntity;
import com.project.springboot.lab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customer/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Integer id) {
        CustomerEntity customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("customers")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @PostMapping("customer")
    public ResponseEntity<Void> addCustomer(CustomerEntity customerEntity) {
        customerService.addCustomer(customerEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
