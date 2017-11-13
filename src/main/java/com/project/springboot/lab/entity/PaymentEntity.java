package com.project.springboot.lab.entity;

import javax.persistence.*;

@Entity
@Table(name = "payment_table")
@NamedQueries({
        @NamedQuery(name = PaymentEntity.QUERY_ALL, query = "SELECT p FROM PaymentEntity p"),
        @NamedQuery(name = PaymentEntity.QUERY_BY_PAYMENT_ID, query = "select p from PaymentEntity p where p.id = :" + PaymentEntity.PARAM_PAYMENT_ID)
})
public class PaymentEntity {

    public static final String QUERY_ALL = "PaymentEntity.findAll";
    public static final String QUERY_BY_PAYMENT_ID = "PaymentEntity.getPaymentById";
    public static final String PARAM_PAYMENT_ID = "paymentId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int summ;

    @Column
    private int bill;

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public int getId() {
        return this.id;
    }

    public int getSumm() {
        return this.summ;
    }

    public int getBill() {
        return this.bill;
    }
}
