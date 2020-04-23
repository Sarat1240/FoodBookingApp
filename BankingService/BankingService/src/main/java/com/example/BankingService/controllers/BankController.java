package com.example.BankingService.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingService.constants.BankingConstants;
import com.example.BankingService.dto.TransactionRequest;
import com.example.BankingService.entity.Transaction;
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
		if(BankingConstants.SUCCESS.equals(status))
			return "Account Created Successfully";
		else
			return "Account was not created";
	}
	

	@PostMapping("/debit")
	public ResponseEntity<Transaction> debitAccount(@RequestBody TransactionRequest trans)
	{
		return bankingService.debitAccount(trans);
	}
	
	@GetMapping("/statement/{month}")
	public ResponseEntity<List<Transaction>> fetchMonthlyStatement(@PathVariable String month)
	{
		 List<Transaction>  txList  = bankingService.fetchMonthlyStatement(month);
		 return new ResponseEntity<List<Transaction>> (txList,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/statement/")
	public ResponseEntity<List<Transaction>> fetchRecentTransactions()
	{
		 List<Transaction>  txList  = bankingService.fetchRecentTransactions();
		 return new ResponseEntity<List<Transaction>> (txList,new HttpHeaders(),HttpStatus.OK);
	}
	
}
