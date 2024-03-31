package com.demo.interfaces;

import java.util.List;

import com.demo.payload.CourseDto;
import com.demo.payload.PostResponse;

public interface CourseService {

	CourseDto createPost(CourseDto postDTO, Integer id, Integer categoryId);

	CourseDto updatePost(CourseDto postDTO, Integer postId);

	void deletePost(Integer postId);

	CourseDto getPostById(Integer postId);

	List<CourseDto> searchPost(String keywords);

	List<CourseDto> getAllPostByUser(Integer id);

	List<CourseDto> getAllPostByCategory(Integer categoryId);

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);

}
