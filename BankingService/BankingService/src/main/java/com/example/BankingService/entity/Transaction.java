package com.example.BankingService.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tid;
	
	private int amount;
	
	private long userid;
	
	private long cardNumber;
	
	private long currentBalance;
	
	private String transactionDate;

	/**
	 * @return the tid
	 */
	public long getTid() {
		return tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(long tid) {
		this.tid = tid;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
	}

	/**
	 * @return the cardNumber
	 */
	public long getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the currentBalance
	 */
	public long getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set 
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", amount=" + amount + ", userid=" + userid + ", cardNumber=" + cardNumber
				+ ", currentBalance=" + currentBalance + ", transactionDate=" + transactionDate + "]";
	}

	

}
