package com.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Role;
import com.demo.entities.RoleType;
//import com.demo.entities.UserRole;

/**
 * RoleRepository
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    
}