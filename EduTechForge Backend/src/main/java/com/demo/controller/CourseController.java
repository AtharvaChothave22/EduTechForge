package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.interfaces.CourseService;
import com.demo.payload.CourseDto;
//import com.demo.serviceimpl.ReponseEntity;

@RestController
@RequestMapping("/courses/api")

public class CourseController {

	@Autowired
	private CourseService courseservice;
	
	@PostMapping("/createpost/{id}/category/{categoryId}")
	public ResponseEntity<CourseDto> createPost(@RequestBody CourseDto postDTO, @PathVariable Integer id,
			@PathVariable Integer categoryId) {
        
		CourseDto postdto = this.courseservice.createPost(postDTO, id, categoryId);
		return new ResponseEntity<CourseDto>(postdto, HttpStatus.CREATED);
	}
	
	@PutMapping("updatepost/postId")
	public ResponseEntity<CourseDto>updatePost(@RequestBody CourseDto postDTO,@PathVariable Integer postId)
	{ 
		CourseDto postdto = this.courseservice.updatePost(postDTO, postId);
		return new ResponseEntity<CourseDto>(postdto, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteById/{postId}")
	public ResponseEntity<String> deleteById( @PathVariable Integer postId) {
		this.courseservice.deletePost(postId);
		return new ResponseEntity<String>("user deleted successfully", HttpStatus.OK);
    }
	
	@GetMapping("/getPostById/{postId}")
	public ResponseEntity<CourseDto> getPost(@PathVariable Integer postId) {
		CourseDto post = this.courseservice.getPostById(postId);
		return new ResponseEntity<CourseDto>(post, HttpStatus.FOUND);

	}
    

	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<CourseDto>> searchPostByTitle(@PathVariable("keywords") String keywords) {
		List<CourseDto> searchedPosts = this.courseservice.searchPost(keywords);
		return new ResponseEntity<List<CourseDto>>(searchedPosts, HttpStatus.FOUND);
	}
	@GetMapping("/allPostsByUser/{id}")
	public ResponseEntity<List<CourseDto>> getAllPostByUser(@PathVariable Integer id) {
		List<CourseDto> allPost = this.courseservice.getAllPostByUser(id);
		return new ResponseEntity<List<CourseDto>>(allPost, HttpStatus.FOUND);
	}
	@GetMapping("/allPostsByCategory/{categoryId}")
	
}
