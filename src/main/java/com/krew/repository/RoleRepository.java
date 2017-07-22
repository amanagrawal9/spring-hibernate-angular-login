package com.krew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krew.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
