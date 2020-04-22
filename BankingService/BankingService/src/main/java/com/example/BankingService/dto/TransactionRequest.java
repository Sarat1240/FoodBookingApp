package com.example.BankingService.dto;

import java.util.Date;

public class TransactionRequest {

	private long tid;
	
	private int amount;
	
	private long userid;
	
	private int price;
	
	private long cardNumber;
	
	private int cvv;
	
	private String expdate;
	
	private String accountno;

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


	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	

	/**
	 * @return the expdate
	 */
	public String getExpdate() {
		return expdate;
	}

	/**
	 * @param expdate the expdate to set
	 */
	public void setExpdate(String expdate) {
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

	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", amount=" + amount + ", userid=" + userid + ", price=" + price
				+ ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expdate=" + expdate + ", accountno=" + accountno
				+ "]";
	}

}
