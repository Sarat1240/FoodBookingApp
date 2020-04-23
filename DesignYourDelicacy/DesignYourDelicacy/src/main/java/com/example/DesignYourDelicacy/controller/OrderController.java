package com.example.DesignYourDelicacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignYourDelicacy.contants.UserConstants;
import com.example.DesignYourDelicacy.dto.TransactionRequest;
import com.example.DesignYourDelicacy.entity.OrderDetails;
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
	private FoodService foodService;

	@PostMapping(value = "/{vendorName}/{itemName}/{username}")
	public String orderItems(@PathVariable String vendorName, @PathVariable String itemName,@PathVariable String username, @RequestBody TransactionRequest transReq) {
		long orderId ;
		String status = userService.verifyUser(username);
		if (UserConstants.USER_EXISTS.equals(status)) 
		{
		   VendorMenu vendor = foodService.searchByVendorAndItem(vendorName, itemName);
		   if (vendor != null)
		   {
			  int itemPrice = vendor.getPrice();
			  orderId = orderService.orderFood(transReq, itemPrice, vendorName, itemName);
		   } 
		   else
		   {
				throw new VendorNotFoundException("Given Vendor details doesn't match. Please try again with different details");
		   }

		} else
			throw new UserNotFoundException("You are not a valid user");
		
		return " Your Order has been created with ID:"+orderId;
	}

	/*
	 * @GetMapping("/{userId}") public ResponseEntity<List<OrderDetails>>
	 * topFiveOrders(@PathVariable("userId")int userId){ List<OrderDetails>
	 * lstOfOrders=orderService.getlatestOrders(userId); return new
	 * ResponseEntity<List<OrderDetails>>(lstOfOrders,new
	 * HttpHeaders(),HttpStatus.OK); }
	 */

}
