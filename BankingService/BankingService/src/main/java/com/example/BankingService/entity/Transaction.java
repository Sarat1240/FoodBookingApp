package com.example.BankingService.entity;

import java.util.Date;

import javax.persistence.Column;
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
	
	private int price;
	
	private long cardNumber;
	
	private String cvv;
	
	private Date expdate;
	
	private String accountno;
	
	private long currentBalance;
	
	private String transactionDate;

	public long getTransid() {
		return tid;
	}

	public void setTransid(long transid) {
		this.tid = transid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}


	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	

	/**
	 * @return the expdate
	 */
	public Date getExpdate() {
		return expdate;
	}

	/**
	 * @param expdate the expdate to set
	 */
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

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
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
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
		return "Transaction [tid=" + tid + ", amount=" + amount + ", userid=" + userid + ", price=" + price
				+ ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expdate=" + expdate + ", accountno=" + accountno
				+ ", currentBalance=" + currentBalance + ", transactionDate=" + transactionDate + "]";
	}


}
