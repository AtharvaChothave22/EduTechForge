package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Course_cards;
import com.demo.entities.User;

public interface CourseRepo extends JpaRepository<Course_cards, Integer> {

	List<Course_cards> findByTitleContaining(String keywords);

	List<Course_cards> findByUser(User user);

}
