package com.example.DesignYourDelicacy.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DesignYourDelicacy.entity.OrderDetails;
import com.example.DesignYourDelicacy.entity.Transaction;
import com.example.DesignYourDelicacy.exception.PaymentFailedException;
import com.example.DesignYourDelicacy.feignclient.BankingFeignClient;
import com.example.DesignYourDelicacy.repository.OrderRepository;
import com.example.DesignYourDelicacy.repository.UserRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BankingFeignClient bankingFeignClient;

	@Override
	public void orderItems(String vendorName, String[] varString) {
		// TODO Auto-generated method stub

	}

	@Override
	public void orderFood(Transaction trans, int itemPrice, String vName, String iName) {
		OrderDetails order = new OrderDetails();

		trans.setPrice(itemPrice);
		ResponseEntity<Transaction> res = bankingFeignClient.debitAccount(trans);
		System.out.println("--------------------------------------------------------");
		System.out.println("Transaction Object in Food Booking App:" + res);
		System.out.println("--------------------------------------------------------");
		if (res.getBody().getTid() != 0) {
			System.out.println("Transaction in Order Service:" + trans);

			order.setItemName(iName);
			order.setOrderAmount(itemPrice);
			order.setVendor(vName);
			order.setOrderDate(new Date().toString());
			//userRepository.save(user);
		//	order.setUser(user);
			orderRepository.save(order);

		} else {
			throw new PaymentFailedException("Payment failed at payment service");
		}

	}

}
