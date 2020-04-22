package com.example.DesignYourDelicacy.dto;

public class UserDto {

	private int id;
	private String name;
	private String location;
	private String gender;
	private long phoneNum;
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
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", location=" + location + ", gender=" + gender
				+ ", phoneNum=" + phoneNum + "]";
	}
	
	

}
