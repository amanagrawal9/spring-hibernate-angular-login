package com.krew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krew.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailId(String emailId);
}
