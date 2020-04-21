package com.example.DesignYourDelicacy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int orderAmount;
	private String orderDate;
	
	
	@ManyToOne
	@JoinColumn
	private User user =  new User();


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the orderAmount
	 */
	public int getOrderAmount() {
		return orderAmount;
	}


	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}


	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}


	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", orderAmount=" + orderAmount + ", orderDate=" + orderDate + ", user=" + user + "]";
	}
	
	

}
