package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Role;
import com.springdatajpa.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyBidirectionalMappingTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRole(){
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("testing");
        user.setEmail("testing@abc.com");
        user.setPassword("password");

        User user2 = new User();
        user2.setFirstName("Ram");
        user2.setLastName("testing");
        user2.setEmail("ram@abc.com");
        user2.setPassword("password");

        Role admin = new Role();
        admin.setName("ADMIN");

        admin.getUsers().add(user2);
        admin.getUsers().add(user);

        user.getRoles().add(admin);
        user2.getRoles().add(admin);

        roleRepository.save(admin);
    }

    @Test
    void fetchRole(){
        List<Role> roles = roleRepository.findAll();

        roles.forEach((r)->{
            System.out.println(r.getName());
            r.getUsers().forEach((u)->{
                System.out.println(u.getFirstName());
            });
        });
    }
}
