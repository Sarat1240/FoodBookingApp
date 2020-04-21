package com.example.DesignYourDelicacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignYourDelicacy.dto.UserDto;
import com.example.DesignYourDelicacy.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	
	@Autowired
	private UserService userService; 
	
	
	@PostMapping
	public String registeruser(@RequestBody UserDto userDto)
	{
		return userService.registeruser(userDto);
	}

}
