package com.flikon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flikon.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailId(String emailId);
}
