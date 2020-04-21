package com.example.DesignYourDelicacy.service;

import java.util.List;

import com.example.DesignYourDelicacy.dto.UserDto;
import com.example.DesignYourDelicacy.entity.VendorMenu;

public interface UserService {

	String registeruser(UserDto userDto);

	String verifyUser(String username,String pwd);

	
	

}
