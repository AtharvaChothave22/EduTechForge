package com.demo.interfaces;

import java.util.List;

import com.demo.entities.Category;
import com.demo.payload.CategoryDto;

public interface CategoryService {

	CategoryDto create(CategoryDto cdto);

	CategoryDto getCategoryById(Integer categoryId);

	CategoryDto updateCategory(CategoryDto categoryDTO, Integer categoryId);

	void deleteCategory(Integer categoryId);
	
	 List<CategoryDto> getAllCategories();

}
