package com.example.DesignYourDelicacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DesignYourDelicacy.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void orderItems(String vendorName, String[] varString) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public void orderItems() {
	 * 
	 * orderRepository.orderItems(vendorName,)
	 * 
	 * }
	 */

}
