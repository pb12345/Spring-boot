package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
interface UserRepository extends JpaRepository<User,Long> {
}
