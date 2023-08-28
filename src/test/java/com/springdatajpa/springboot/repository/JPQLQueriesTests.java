package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("prod1","updated desc");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("prod1","updated desc");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }
}
