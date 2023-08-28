package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void paginationMethod(){

        int pageNo = 0;
        int pageSize = 5;

        //create a pageable object
        Pageable pageable = PageRequest.of(pageNo,pageSize);

        Page<Product> prouctsPage = productRepository.findAll(pageable);

        List<Product> products = prouctsPage.getContent();

        products.forEach((p)->{
            System.out.println(p);
        });

        //total pages
        System.out.println("total pages ->"+prouctsPage.getTotalPages());
        //total elements
        System.out.println("total elemetns ->" + prouctsPage.getTotalElements());
        //no. of elements
        System.out.println("total number of elements ->" + prouctsPage.getNumberOfElements());
        //size
        System.out.println("page size ->" + prouctsPage.getSize());
        //last
        System.out.println("Last? ->" + prouctsPage.isLast());
        //first
        System.out.println("First? ->" + prouctsPage.isFirst());

    }

    @Test
    void sortingMethod(){

        String sortBy = "price";
        String sortDir = "desc";
        //List<Product> products = productRepository.findAll(Sort.by(sortBy).ascending());
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<Product> products = productRepository.findAll(sort);
        products.forEach((p)->{
            System.out.println(p);
        });
    }

    @Test
    void sortingByMultipleFields(){
        String sortByName = "name";
        String sortByDesc = "description";
        String sortDir = "desc";

        Sort nameSort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByName).ascending() : Sort.by(sortByName).descending();
        Sort descSort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort groupBySort = nameSort.and(descSort);

        List<Product> products = productRepository.findAll(groupBySort);

        products.forEach((p)->{
            System.out.println(p);
        });
    }

    @Test
    void pagingAndSortingMethod(){
        String sortBy = "name";
        String sortDir = "desc";
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        int pageNumber = 0;
        int pageSize = 3;
        Pageable page = PageRequest.of(pageNumber,pageSize,sort);

        Page<Product> products = productRepository.findAll(page);

        List<Product> productList = products.getContent();

        productList.forEach((p)->{
            System.out.println(p);
        });
    }
}
