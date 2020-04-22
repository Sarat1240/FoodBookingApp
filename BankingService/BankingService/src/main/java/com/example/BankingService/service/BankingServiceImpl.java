package com.example.BankingService.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BankingService.dto.TransactionRequest;
import com.example.BankingService.entity.Account;
import com.example.BankingService.entity.Transaction;
import com.example.BankingService.exception.CardNotFoundException;
import com.example.BankingService.repo.AccountRepository;
import com.example.BankingService.repo.BankRepository;
import com.example.BankingService.repo.TransactionRepository;


@Service
@Transactional
public class BankingServiceImpl implements BankingService {

	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public String registerAccount(long cardNumber, int cvv, String expiryDate) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setAccountNumber(getAccountNumber());
		account.setCardNumber(cardNumber);
		account.setCvv(cvv);
		account.setExpiryDate(expiryDate);
		/*
		 * try { account.setExpiryDate(formatDate(expiryDate)); } catch (ParseException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		account.setAccountType("Savings");
		account.setOpeningBalance(10000);
		account.setCurrentBalance(10000);

		Account acc = bankRepository.save(account);
		if (acc != null)
			return "Success";
		else

			return "Failure";

	}

	public static Date formatDate(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = format.parse(date);
		return date1;
	}

	private long getAccountNumber() {
		/* return a random long of 16 length */
		long smallest = 1000_0000_0000_0000L;
		long biggest = 9999_9999_9999_9999L;

		// return a long between smallest and biggest (+1 to include biggest as well
		// with the upper bound)
		long random = ThreadLocalRandom.current().nextLong(smallest, biggest + 1);
		System.out.println(random);
		return random;
	}

	@Override
	public ResponseEntity<Transaction> debitAccount(TransactionRequest trans) {
		System.out.println("-------------------------------");
		System.out.println(trans);
		System.out.println("-------------------------------");
		Optional<Account> acc = accountRepository.findByCardNumberAndCvvAndExpiryDate(trans.getCardNumber(),trans.getCvv(),trans.getExpdate());
		
		//accountRepository.updateAccountBalance(trans.getCardNumber(),trans.getPrice());
		Transaction t =null;
		if(acc.isPresent())
		{
			System.out.println("account details are:"+acc);
			Account a = acc.get();
			a.setCurrentBalance(a.getCurrentBalance()-trans.getPrice());
			accountRepository.save(a);
			
			Transaction tx = new Transaction();
			tx.setCardNumber(trans.getCardNumber());
			tx.setAmount(trans.getPrice());
			tx.setCurrentBalance(a.getCurrentBalance()-trans.getPrice());
			tx.setTransactionDate(new Date().toString());
			tx.setUserid(trans.getUserid());
			 t = transactionRepository.save(tx);
			
		}
		else
		    throw new CardNotFoundException("Provided invalid Card or Cvv or Expired date details");
		return new ResponseEntity<Transaction>(t,HttpStatus.CREATED);
	}

	@Override
	public List<Transaction> fetchStatement(String month) {
		return transactionRepository.fetchStatementByMonth(month);
	
	}

	@Override
	public List<Transaction> fetchRecentTransactions() {
		// TODO Auto-generated method stub
	    return transactionRepository.fetchRecentTransactions(5);
	}

}
