package com.demo.dao;
import com.demo.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category, Integer> 
{

	
}

