package com.example.DesignYourDelicacy.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.DesignYourDelicacy.entity.Transaction;
import com.example.DesignYourDelicacy.entity.VendorMenu;

public interface FoodService {

	List<VendorMenu> searchVendor(String vendorName);
	
	List<VendorMenu> searchByItem(String item);
	
	VendorMenu searchByVendorAndItem(String vendorname, String item);

	ResponseEntity<Transaction> debitAccount(Transaction trans);
	

}
