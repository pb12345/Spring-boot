package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
/*@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor*/
@Data
public class OrderItem {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String imageUrl;
    private BigDecimal price;
    private int quantity;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}
