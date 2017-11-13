package com.project.springboot.lab.jpa.impl;

import com.project.springboot.lab.entity.PaymentEntity;
import com.project.springboot.lab.jpa.PaymentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PaymentJpaImpl implements PaymentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PaymentEntity> getAllPayments() {
        return entityManager.createNamedQuery(PaymentEntity.QUERY_ALL, PaymentEntity.class).getResultList();
    }

    @Override
    public PaymentEntity getPaymentById(int paymentId) {
        return (PaymentEntity) entityManager.createQuery(PaymentEntity.QUERY_BY_PAYMENT_ID, PaymentEntity.class)
                .setParameter(PaymentEntity.QUERY_BY_PAYMENT_ID, paymentId);
    }

    @Override
    public void addPayment(PaymentEntity paymentEntity) {
        entityManager.persist(paymentEntity);
    }

    @Override
    public void updatePayment(PaymentEntity paymentEntity) {
        PaymentEntity payment = getPaymentById(paymentEntity.getId());
        payment.setBill(paymentEntity.getBill());
        payment.setSumm(paymentEntity.getSumm());
        entityManager.flush();
    }

    @Override
    public void deletePayment(int paymentId) {
        entityManager.remove(getPaymentById(paymentId));
    }
}
