package com.example.BankingService.service;

public interface BankingService {

	String registerAccount(long cardNumber, int cvv, String expirydate);

	String debitAccount(long cardNumber, int cvv, int itemPrice);
	

}
