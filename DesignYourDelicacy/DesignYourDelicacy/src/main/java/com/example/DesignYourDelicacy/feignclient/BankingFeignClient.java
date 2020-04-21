package com.example.DesignYourDelicacy.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.DesignYourDelicacy.entity.Transaction;



@FeignClient(name="http://banking-service/banks")
public interface BankingFeignClient {
	
	
	@PostMapping("/debit")
	public ResponseEntity<Transaction> debitAccount(@RequestBody Transaction trans);
	
	

}
