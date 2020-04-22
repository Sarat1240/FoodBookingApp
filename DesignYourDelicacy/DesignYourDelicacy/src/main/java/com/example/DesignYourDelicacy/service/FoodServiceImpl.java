package com.example.DesignYourDelicacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DesignYourDelicacy.entity.Transaction;
import com.example.DesignYourDelicacy.entity.VendorMenu;
import com.example.DesignYourDelicacy.feignclient.BankingFeignClient;
import com.example.DesignYourDelicacy.repository.VendorRepository;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	
	@Autowired
	private VendorRepository vendorRepo;
	
	@Autowired
	private BankingFeignClient bankingFeignClient;
	
	@Override
	public List<VendorMenu> searchVendor(String vendorName) {
		// TODO Auto-generated method stub
		return vendorRepo.findByVendorName(vendorName);
		/*
		 * VendorMenu vm = null; if(vendor.isPresent()) { vm = vendor.get(); } return
		 * vm;
		 */
	}

	@Override
	public List<VendorMenu> searchByItem(String item) {
		return vendorRepo.findByItemName(item);
	}

	@Override
	public VendorMenu searchByVendorAndItem(String vendorname, String item) {
		// TODO Auto-generated method stub
		return vendorRepo.findByVendorNameAndItemName(vendorname,item);
	}
	/*
	 * @Override public ResponseEntity<Transaction> debitAccount(Transaction trans)
	 * { // TODO Auto-generated method stub return
	 * bankingFeignClient.debitAccount(trans); }
	 */

	@Override
	public ResponseEntity<Transaction> debitAccount(Transaction trans) {
		// TODO Auto-generated method stub
		return null;
	}


}
