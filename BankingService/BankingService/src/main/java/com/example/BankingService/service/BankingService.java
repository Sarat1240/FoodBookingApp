package com.example.BankingService.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.BankingService.dto.TransactionRequest;
import com.example.BankingService.entity.Transaction;

public interface BankingService {

	String registerAccount(long cardNumber, int cvv, String expirydate);

	ResponseEntity<Transaction> debitAccount(TransactionRequest trans);

	List<Transaction> fetchStatement(String month);

	List<Transaction> fetchRecentTransactions();
	

}
