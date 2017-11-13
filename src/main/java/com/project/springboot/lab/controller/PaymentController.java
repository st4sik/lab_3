package com.project.springboot.lab.controller;

import com.project.springboot.lab.entity.PaymentEntity;
import com.project.springboot.lab.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("payment/{id}")
    public ResponseEntity<PaymentEntity> getPaymentById(@PathVariable("id") Integer id) {
        PaymentEntity payment = paymentService.getPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping("payments")
    public ResponseEntity<List<PaymentEntity>> getAllPayments() {
        List<PaymentEntity> allPayments = paymentService.getAllPayments();
        return new ResponseEntity<>(allPayments, HttpStatus.OK);
    }

    @PostMapping("payment")
    public ResponseEntity<Void> addPayment(PaymentEntity paymentEntity) {
        paymentService.addPayment(paymentEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("payment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable("id") Integer id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
