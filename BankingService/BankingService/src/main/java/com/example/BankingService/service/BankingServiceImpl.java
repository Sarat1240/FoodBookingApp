package com.example.BankingService.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BankingService.entity.Account;
import com.example.BankingService.repo.BankRepository;

@Service
@Transactional
public class BankingServiceImpl implements BankingService {
	
	@Autowired
	private BankRepository bankRepository;

	@Override
	public String registerAccount(long cardNumber, int cvv, String expiryDate)
	{
		// TODO Auto-generated method stub
		
		Account account = new Account();
		account.setAccountNumber(getAccountNumber());
		account.setCardNumber(cardNumber);
		account.setCvv(cvv);
		account.setExpiryDate(expiryDate);
		account.setAccountType("Savings");
		account.setOpeningBalance(10000);
		account.setCurrentBalance(10000);
		
		Account acc = bankRepository.save(account);
		if(acc!=null)
			return "Success";
		else
			
			return "Failure";
		
	}

	private long getAccountNumber() {
	    /* return a random long of 16 length */
	    long smallest = 1000_0000_0000_0000L;
	    long biggest =  9999_9999_9999_9999L;

	    // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
	    long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
	    System.out.println(random);
	    return random;
	}

	@Override
	public String debitAccount(long cardNumber, int cvv, int price) {
		//bankRepository.
		
		return "";
	} 

}
