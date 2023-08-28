package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTests {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();

        order.setOrderTrackingNumber("0001ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(2000));

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
    void updateOrderMethod() {
        Order order = orderRepository.findById(1L).get();

        order.setStatus("Delivered");
        order.getBillingAddress().setZipCode("000121");
        orderRepository.save(order);
    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }

}
