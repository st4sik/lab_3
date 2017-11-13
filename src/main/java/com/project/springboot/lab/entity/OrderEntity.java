package com.project.springboot.lab.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
@NamedQueries({
        @NamedQuery(name = OrderEntity.QUERY_ALL, query = "SELECT o FROM OrderEntity o"),
        @NamedQuery(name = OrderEntity.QUERY_BY_ORDER_ID, query = "select o from OrderEntity o where o.id = :" + OrderEntity.PARAM_ORDER_ID)
})
public class OrderEntity {
    public static final String QUERY_BY_ORDER_ID = "OrderEntity.getOrderById";
    public static final String QUERY_ALL = "OrderEntity.findAll";
    public static final String PARAM_ORDER_ID = "orderId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int numberOrders;

    @Column
    private String date;

    @Column
    private int customerFk;

    @Column
    private int paymentFk;

    @Column
    private int productFk;

    @Column
    private int summ;

    public void setNumber(int numberOrders) {
        this.numberOrders = numberOrders;
    }

    public void setCustomer(int customerFk) {
        this.customerFk = customerFk;
    }

    public void setPayment(int paymentFk) {
        this.paymentFk = paymentFk;
    }

    public void setProduct(int productFk) {
        this.productFk = productFk;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public int getNumber() {
        return this.numberOrders;
    }

    public int getId() {
        return this.id;
    }

    public int getCustomer() {
        return this.customerFk;
    }

    public int getPayment() {
        return this.paymentFk;
    }

    public int getProduct() {
        return this.productFk;
    }

    public String getDate() {
        return this.date;
    }

    public int getSumm() {
        return this.summ;
    }
}
