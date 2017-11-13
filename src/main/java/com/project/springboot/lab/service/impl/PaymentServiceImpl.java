package com.project.springboot.lab.service.impl;

import com.project.springboot.lab.entity.PaymentEntity;
import com.project.springboot.lab.jpa.PaymentRepository;
import com.project.springboot.lab.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    @Override
    public PaymentEntity getPaymentById(int paymentId) {
        return paymentRepository.getPaymentById(paymentId);
    }

    @Override
    public void addPayment(PaymentEntity paymentEntity) {
        paymentRepository.addPayment(paymentEntity);
    }

    @Override
    public void updatePayment(PaymentEntity paymentEntity) {
        paymentRepository.updatePayment(paymentEntity);
    }

    @Override
    public void deletePayment(int paymentId) {
        paymentRepository.deletePayment(paymentId);
    }
}
