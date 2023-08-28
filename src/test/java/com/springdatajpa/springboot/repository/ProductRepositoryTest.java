package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("prod1");
        product.setDescription("prod1 desc");
        product.setSku("100ABCD");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save the product
        Product savedObj = productRepository.save(product);

        Product product1 = new Product();
        product1.setName("prod2");
        product1.setDescription("prod2 desc");
        product1.setSku("100ABC");
        product1.setPrice(new BigDecimal(200));
        product1.setActive(true);
        product1.setImageUrl("product2.png");

        //save the product
        Product savedObj1 = productRepository.save(product1);

        //display saved product
        System.out.println(savedObj.getId());
        System.out.println(savedObj.toString());

    }
    @Test
    void updateUsingSaveMethod(){
        //find by id
        Long id = 1L;
        Product prod = productRepository.findById(id).get();
        //update entity info
        prod.setName("updated prod1");
        prod.setDescription("updated desc");
        //save updated entity
        productRepository.save(prod);
    }
}