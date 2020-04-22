package com.example.DesignYourDelicacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DesignYourDelicacy.dto.UserDto;
import com.example.DesignYourDelicacy.entity.User;
import com.example.DesignYourDelicacy.entity.VendorMenu;
import com.example.DesignYourDelicacy.repository.UserRepository;
import com.example.DesignYourDelicacy.repository.VendorRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public String registeruser(UserDto userDto) {
		
		User  u = convertToUser(userDto);
		User u1  = userRepository.save(u);
		if(u1!=null)
		   return "User Registered";
		else
			return "User Registration failed";
	}
	
	public User convertToUser(UserDto userDto)
	{
		User u = new User();
		u.setId(userDto.getId());
		u.setName(userDto.getName());
		u.setGender(userDto.getGender());
		u.setLocation(userDto.getLocation());
		u.setPhoneNum(userDto.getPhoneNum());
		
		return u;
	}

	@Override
	public String verifyUser(String username) {
		// TODO Auto-generated method stub
		Optional<User>  u = userRepository.findByName(username);
		if(u.isPresent())
			return "exists";
		else
			return "not exists";
		
	}

}
