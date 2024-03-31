package com.demo.controller;

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

import com.demo.entities.User;
import com.demo.interfaces.UserService;
import com.demo.payload.LoginRequestDto;
import com.demo.payload.UserDto;

@RestController
@RequestMapping("edutech/api/users")
public class UserController
{
	@Autowired
	private UserService userService;

	@PostMapping("/student/register")
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
		System.out.println(userDto);
        User user2= userService.createUser(userDto);
		System.out.println(user2);
		return new ResponseEntity<User>(user2,HttpStatus.CREATED);

   }
	
	@PostMapping("/trainer/register")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
		System.out.println(userDto);
        User user2= userService.registerUser(userDto);
		System.out.println(user2);
		return new ResponseEntity<User>(user2,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User>loginUser(@RequestBody LoginRequestDto logindto)
	{
	 return ResponseEntity.ok(userService.login(logindto));
	} 
	
	@PutMapping("/updateUserById/{id}")
	public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto, @PathVariable Integer id) {
		UserDto updatedUser = this.userService.updateUser(userDto, id);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		this.userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted successfully", HttpStatus.OK);

	}

	
	
	
	
	
	
	

  
}
