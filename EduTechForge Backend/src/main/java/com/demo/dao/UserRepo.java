package com.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	User findByEmailAndPassword(String Email,String Password);
	//select User from User e where e.email=? And e.password=?;
	}