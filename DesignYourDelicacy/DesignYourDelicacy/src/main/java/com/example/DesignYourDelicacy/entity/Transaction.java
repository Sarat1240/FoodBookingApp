package com.example.DesignYourDelicacy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="transaction")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tid;
	private long userid;
	private long cardNumber;
	//@NotBlank(message = "Please enter cvv")
	private String cvv;
	//@NotBlank(message = "Please enter expdate")
	private String expdate;
	private String vendorId;
	private String itemName;
	private String transactiondate;
	private int price; 

	public long getTransid() {
		return tid;
	}

	public void setTransid(long transid) {
		this.tid = transid;
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
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the transactiondate
	 */
	public String getTransactiondate() {
		return transactiondate;
	}

	/**
	 * @param transactiondate the transactiondate to set
	 */
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
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
		return "Transaction [tid=" + tid + ", userid=" + userid + ", cardNumber=" + cardNumber + ", cvv=" + cvv
				+ ", expdate=" + expdate + ", vendorId=" + vendorId + ", itemName=" + itemName + ", transactiondate="
				+ transactiondate + ", price=" + price + "]";
	}

	
	
	
	
}
