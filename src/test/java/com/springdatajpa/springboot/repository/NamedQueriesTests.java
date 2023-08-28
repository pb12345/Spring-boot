package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){
        Product product = productRepository.findByPrice(new BigDecimal(100));
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

/*    @Test
    void namedJPQLQueries(){
        List<Product> products = productRepository.findAllOrderByNameDescription();
        products.forEach((p)->{
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });

        Product product = productRepository.findByPrice(new BigDecimal(300));
        System.out.println(product.getId());
        System.out.println(product.getName());
    }*/

    @Test
    void namedNativeSQLQuery(){
        Product product = productRepository.findByDescription("updated desc");
        System.out.println(product.getDescription());
    }
}
