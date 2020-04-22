package com.example.DesignYourDelicacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignYourDelicacy.entity.Transaction;
import com.example.DesignYourDelicacy.entity.VendorMenu;
import com.example.DesignYourDelicacy.exception.UserNotFoundException;
import com.example.DesignYourDelicacy.exception.VendorNotFoundException;
import com.example.DesignYourDelicacy.feignclient.BankingFeignClient;
import com.example.DesignYourDelicacy.service.FoodService;
import com.example.DesignYourDelicacy.service.OrderService;
import com.example.DesignYourDelicacy.service.UserService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankingFeignClient bankingFeignClient;
	
	@Autowired
	private  FoodService foodService;
	
	@PostMapping(value="/{vendorName}/{itemName}/{username}")
	public void orderItems(@PathVariable String vendorName,@PathVariable String itemName,@PathVariable String username,@RequestBody Transaction trans)
	{
		String status = userService.verifyUser(username);
		if("exists".equals(status))
		{
			VendorMenu vendor = foodService.searchByVendorAndItem(vendorName, itemName);
			if(vendor!=null)
			{
			int itemPrice = vendor.getPrice();			
				orderService.orderFood(trans,itemPrice,vendorName,itemName);
			//	foodService.debitAccount(trans);
				    
			}
			else
			{
				throw new VendorNotFoundException("Given Vendor details doesn't match. Please try again with different details");
			}
		
		}
		else		
			throw new UserNotFoundException("You are not a valid user");
		
			
		
		
	}


}
