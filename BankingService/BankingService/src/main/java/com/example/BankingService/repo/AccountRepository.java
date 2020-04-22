package com.example.BankingService.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BankingService.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<Account> findByCardNumberAndCvvAndExpiryDate(long l, int cvv, String expdate);

	/*
	 * @Query("update Account acc set currentBalance=currentBalance-?2 where cardNumber=?1"
	 * ) void updateAccountBalance(long cardNumber, int price);
	 */

}
