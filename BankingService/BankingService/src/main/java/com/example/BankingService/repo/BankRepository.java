package com.example.BankingService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankingService.entity.Account;

@Repository
public interface BankRepository extends JpaRepository<Account, Integer> {

}
