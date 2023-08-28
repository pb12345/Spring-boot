package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //Define JPQL using @Query annotation

    @Query("select p from Product p where p.name = ?1 or p.description = ?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);

    //Define JPQL with named params
    @Query("select p from Product p where p.name = :name or p.description = :description")
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name, @Param("description") String description);

    //Defining native SQL queries using indexed params

    @Query(value = "select * from products p where p.name = ?1 or p.description = ?2", nativeQuery = true)
    Product findByNameOrDescriptionSQLIndexParam(String name, String description);

    //Defining SQL queries using named params


    @Query(value = "select * from products p where p.name = :name or p.description = :description", nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name, @Param("description") String description);

    Product findByPrice(@Param("price") BigDecimal price);

    /*List<Product> findAllOrderByNameDescription();*/

    //Define named native SQL query

    @Query(nativeQuery = true)
    Product findByDescription(String description);
}
