package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("books");
        productCategory.setCategoryDescription("books desc");

        Product product1 = new Product();
        product1.setName("core java");
        product1.setPrice(new BigDecimal(100));
        product1.setImageUrl("img1.png");
        product1.setSku("001ABC");
        product1.setActive(true);
        product1.setCategory(productCategory);

        productCategory.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("core python");
        product2.setPrice(new BigDecimal(200));
        product2.setImageUrl("img2.png");
        product2.setSku("002ABC");
        product2.setActive(true);
        product2.setCategory(productCategory);

        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);
    }

    @Test
    void fetchProductCategory(){
        ProductCategory productCategory = productCategoryRepository.findById(1L).get();
        System.out.println(productCategory.getCategoryName());
    }
}