package com.flikon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flikon.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
