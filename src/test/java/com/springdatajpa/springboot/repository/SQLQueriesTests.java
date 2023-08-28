package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SQLQueriesTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLIndexParam("prod1","updated desc");
        System.out.println(product.getId());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("prod1","updated desc");
        System.out.println(product.getId());
        System.out.println(product.getDescription());
    }
}
