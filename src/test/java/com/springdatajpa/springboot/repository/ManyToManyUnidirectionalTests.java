package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Role;
import com.springdatajpa.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveUserMethod() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("testing");
        user.setEmail("testing@abc.com");
        user.setPassword("password");

        Role admin = new Role();
        admin.setName("ADMIN");

        Role customer = new Role();
        customer.setName("CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);
        userRepository.save(user);
    }

    @Test
    void updateUser() {
        User user = userRepository.findById(1L).get();
        user.setFirstName("Ram");
        user.setLastName("test");
        user.setEmail("ram@test.com");

        Role userRole = new Role();
        userRole.setName("USER");

        user.getRoles().add(userRole);
        userRepository.save(user);
    }

    @Test
    void fetchUser(){
        User user = userRepository.findById(1L).get();
        System.out.println(user.getEmail());
        user.getRoles().forEach((role)->{
            System.out.println(role.getName());
        });
    }

    @Test
    void deleteUser(){

        userRepository.deleteById(1L);
    }
}
