package com.example.DesignYourDelicacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignYourDelicacy.entity.VendorMenu;
import com.example.DesignYourDelicacy.exception.UserNotFoundException;
import com.example.DesignYourDelicacy.service.FoodService;
import com.example.DesignYourDelicacy.service.UserService;

@RestController
@RequestMapping(value = "/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;	
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/{vendorName}/{username}")
	public ResponseEntity<List<VendorMenu>> searchVendor(@PathVariable String vendorName,@PathVariable String username)
	{
	
		String status = userService.verifyUser(username);
		
		if("not exists".equals(status))
			throw new UserNotFoundException("You are not a valid user to search the vendor name");
			
		List<VendorMenu> vlist =  foodService.searchVendor(vendorName);
		return new ResponseEntity<List<VendorMenu>>(vlist,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{item}")
	public ResponseEntity<List<VendorMenu>> searchByItem(@PathVariable String  item)
	{
	
		List<VendorMenu> vlist = foodService.searchByItem(item);
		
		    return new ResponseEntity<List<VendorMenu>>(vlist,new HttpHeaders(),HttpStatus.OK);
	
	}
	@GetMapping(value="/{vendorName}/{item}")
	public ResponseEntity<VendorMenu> searchByVendorAndItem(String vendorname, String item)
	{
		VendorMenu vm =  foodService.searchByVendorAndItem(vendorname, item);
		
		  return new ResponseEntity<VendorMenu>(vm,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	
	
}
