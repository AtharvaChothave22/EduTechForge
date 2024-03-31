package com.demo.interfaces;

import org.springframework.http.ResponseEntity;

import com.demo.entities.User;
import com.demo.payload.LoginRequestDto;
import com.demo.payload.UserDto;

public interface UserService {

	User createUser(UserDto userDto);

	User registerUser(UserDto userDto);

	User login(LoginRequestDto logindto);

	UserDto updateUser(UserDto userDto, Integer userId);

	void deleteUser(Integer userId);

}
