package com.example.BankingService.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Account implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detailed_pk")
	private int aid;
	private long accountNumber;
	private long cardNumber;
	private int cvv;
	private String expiryDate;
	private String accountType;
	private long openingBalance;
	private long currentBalance;
	
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}




	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}




	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}




	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
	 * @return the cvv
	 */
	public int getCvv() {
		return cvv;
	}




	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}




	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}




	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}




	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}




	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}




	/**
	 * @return the openingBalance
	 */
	public long getOpeningBalance() {
		return openingBalance;
	}




	/**
	 * @param openingBalance the openingBalance to set
	 */
	public void setOpeningBalance(long openingBalance) {
		this.openingBalance = openingBalance;
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




	@Override
	public String toString() {
		return "Account [aid=" + aid + ", accountNumber=" + accountNumber + ", cardNumber=" + cardNumber + ", cvv="
				+ cvv + ", expiryDate=" + expiryDate + ", accountType=" + accountType + ", openingBalance="
				+ openingBalance + ", currentBalance=" + currentBalance + "]";
	}
	
	
	

}
