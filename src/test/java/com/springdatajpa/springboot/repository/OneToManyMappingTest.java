package com.springdatajpa.springboot.repository;


import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.entity.Order;
import com.springdatajpa.springboot.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    //save order and order items

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setStatus("IN PROGRESS");

        //create order item #1
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct((productRepository.findById(1L).get()));
        orderItem.setQuantity(2);
        orderItem.setPrice(orderItem.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem.setImageUrl("image1.png");
        order.getOrderItems().add((orderItem));

        //create order item #2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct((productRepository.findById(2L).get()));
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        order.getOrderItems().add((orderItem2));

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        Address address = new Address();
        address.setCity("Pune");
        address.setState("MH");
        address.setStreet("123 Fisrt Street");
        address.setCountry("India");
        address.setZipCode("000123");

        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void fetchOrderMethod(){
        Order order = orderRepository.findById(1L).get();
        System.out.println(order.getStatus());

        for(OrderItem item : order.getOrderItems()){
            System.out.println(item.getProduct().getName());
        }
    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }
}
