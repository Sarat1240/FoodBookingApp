package com.example.DesignYourDelicacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class VendorMenu {
	
	@Column(name = "vendor_id")
	private int vendorId;
	@Column(name = "vendor_name")
	private String vendorName;
	@Id
	@Column(name = "serial_num")
	private int serialNum;
	@Column(name = "item_name")
	private String itemName;
	@Column(name ="item_desc")
	private String itemDesc;
	@Column(name = "price")
	private int price;
	/**
	 * @return the vendorId
	 */
	public int getVendorId() {
		return vendorId;
	}
	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	/**
	 * @return the serialNum
	 */
	public int getSerialNum() {
		return serialNum;
	}
	/**
	 * @param serialNum the serialNum to set
	 */
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
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
	 * @return the itemDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}
	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
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
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	
	@Override
	public String toString() {
		return "VendorMenu [vendorId=" + vendorId + ", vendorName=" + vendorName + ", serialNum=" + serialNum
				+ ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", price=" + price + "]";
	}
	

	
	

}
