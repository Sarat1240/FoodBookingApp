package com.example.BankingService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BankingService.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query("select t from Transaction t where t.transactionDate like %:month% ")
	List<Transaction> fetchStatementByMonth(String month);

	@Query(value = "SELECT * FROM Transaction order by transaction_date desc limit :limit", nativeQuery = true) 
	List<Transaction> fetchRecentTransactions(int limit);
	
}
