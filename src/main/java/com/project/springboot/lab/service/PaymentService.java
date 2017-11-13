package com.project.springboot.lab.service;

import com.project.springboot.lab.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    List<PaymentEntity> getAllPayments();

    PaymentEntity getPaymentById(int paymentId);

    void addPayment(PaymentEntity paymentEntity);

    void updatePayment(PaymentEntity paymentEntity);

    void deletePayment(int paymentId);
}
