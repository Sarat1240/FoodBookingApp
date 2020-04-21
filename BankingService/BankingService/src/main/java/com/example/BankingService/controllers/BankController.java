package com.example.BankingService.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingService.service.BankingService;



@RestController
@RequestMapping(value = "/banks")
public class BankController {
	
	@Autowired
	private BankingService bankingService;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/info")
	public String getInfo() {
		String port = environment.getProperty("local.server.port");
		return "From server "+port;
	}
	
	@PostMapping(value = "/register/{cardNumber}/{cvv}/{expirydate}")
	public String registerAccount(@Valid @PathVariable("cardNumber") @NotNull long  cardNumber,@PathVariable("cvv") int cvv,@PathVariable("expirydate") String expirydate)
	{
		
		String status = bankingService.registerAccount(cardNumber,cvv,expirydate);
		if("Success".equals(status))
			return "Account Created Successfully";
		else
			return "Account was not created";
	}
	
	@PostMapping()
	public String debitAccount(long cardNumber, int cvv, int itemPrice)
	{
		return bankingService.debitAccount(cardNumber,cvv,itemPrice);
	}

}
