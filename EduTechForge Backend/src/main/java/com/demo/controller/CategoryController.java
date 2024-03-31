package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Category;
import com.demo.interfaces.CategoryService;
import com.demo.payload.CategoryDto;

@RestController
@RequestMapping("/category/api")
public class CategoryController {
	
	@Autowired 
	private CategoryService category;
	
	@PostMapping("/addnew")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto cdto)
	{ 
	return ResponseEntity.ok(category.create(cdto));
	}
	
	@GetMapping("/getCategoryByID/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {

		return ResponseEntity.ok(this.category.getCategoryById(categoryId));
	}
	@PutMapping("/updateCategoryById/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDTO,
			@PathVariable Integer categoryId) {
		return new ResponseEntity<CategoryDto>(this.category.updateCategory(categoryDTO, categoryId),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteById/{categoryId}")
	public ResponseEntity<String> deleteById(@PathVariable Integer categoryId) {
		this.category.deleteCategory(categoryId);
		return new ResponseEntity<String>("user deleted successfully", HttpStatus.OK);

	}
	@GetMapping("/allCategories")
	public ResponseEntity<List<CategoryDto>>getAllCategories() {

		return ResponseEntity.ok(this.category.getAllCategories());
	}
}
