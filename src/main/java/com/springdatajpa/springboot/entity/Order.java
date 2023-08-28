package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;

    //default fetch type for OneToMany is lazy
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER , mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    public BigDecimal getTotalAmount(){
        BigDecimal amount = new BigDecimal(0.0);
        for(OrderItem item : orderItems){
            amount = amount.add(item.getPrice().multiply(new BigDecimal(totalQuantity)));
        }
        return amount;
    }

}
