package com.example.DesignYourDelicacy.entity;

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
	
	private int price;
	
	private long userid;
	
	private long cardNumber;
	
	private String cvv;
	
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


	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpdate() {
		return expdate;
	}

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

	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", amount=" + amount + ", price=" + price + ", userid=" + userid
				+ ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expdate=" + expdate + ", accountno=" + accountno
				+ "]";
	}
	
	
	


	
	
	
	
}
