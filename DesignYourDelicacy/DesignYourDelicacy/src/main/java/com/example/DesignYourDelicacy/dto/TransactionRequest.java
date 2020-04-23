package com.example.DesignYourDelicacy.dto;

public class TransactionRequest {

	private long cardNumber;
	// @NotBlank(message = "Please enter cvv")
	private String cvv;
	// @NotBlank(message = "Please enter expdate")
	private String expdate;
	
	private long userid;
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
	public String getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(String cvv) {
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
	
	

}
