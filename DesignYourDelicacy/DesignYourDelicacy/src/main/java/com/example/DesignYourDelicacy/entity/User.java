package com.example.DesignYourDelicacy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5126549699402341494L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String location;
	private String gender;
	private long phoneNum;


	
	@OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderDetails> orderList  = new ArrayList<OrderDetails>();


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the phoneNum
	 */
	public long getPhoneNum() {
		return phoneNum;
	}


	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}


	/**
	 * @return the orderList
	 */
	public List<OrderDetails> getOrderList() {
		return orderList;
	}


	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(List<OrderDetails> orderList) {
		this.orderList = orderList;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", location=" + location + ", gender=" + gender + ", phoneNum="
				+ phoneNum + ", orderList=" + orderList + "]";
	}
	
	
	
	

}
