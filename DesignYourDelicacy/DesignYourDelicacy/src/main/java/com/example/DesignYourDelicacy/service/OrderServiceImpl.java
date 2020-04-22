package com.example.DesignYourDelicacy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DesignYourDelicacy.entity.OrderDetails;
import com.example.DesignYourDelicacy.entity.Transaction;
import com.example.DesignYourDelicacy.entity.User;
import com.example.DesignYourDelicacy.exception.PaymentFailedException;
import com.example.DesignYourDelicacy.exception.UserNotFoundException;
import com.example.DesignYourDelicacy.feignclient.BankingFeignClient;
import com.example.DesignYourDelicacy.repository.OrderRepository;
import com.example.DesignYourDelicacy.repository.TransactionRepository;
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
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void orderItems(String vendorName, String[] varString) {
		// TODO Auto-generated method stub

	}

	@Override
	public void orderFood(Transaction trans, int itemPrice, String vName, String iName) {
		OrderDetails order = new OrderDetails();
		Optional<User> user = userRepository.findById((int) trans.getUserid());
		if(user.isPresent())
		{
			User u = user.get();
			trans.setPrice(itemPrice);
			ResponseEntity<Transaction> res = bankingFeignClient.debitAccount(trans);
			System.out.println("--------------------------------------------------------");
			System.out.println("Transaction Object in Food Booking App:" + res);
			System.out.println("--------------------------------------------------------");
			if (res.getBody().getTid() != 0)
			{
				System.out.println("Transaction in Order Service:" + trans);

				order.setItemName(iName);
				order.setOrderAmount(itemPrice);
				order.setVendor(vName);
				order.setOrderDate(new Date().toString());
			
				
				  
				  ArrayList<OrderDetails> olist = new ArrayList<OrderDetails>();
				  olist.add(order);
				  u.setOrderList(olist);
					order.setUser(u);
				 
				 
				 
				userRepository.save(u);
			//	order.setUser(user);
			//	OrderDetails savedOrder = orderRepository.save(order);
				/*
				 * if(savedOrder!=null) { Transaction t = new Transaction(); t.set }
				 */
				
				Transaction t = new Transaction();
				t.setVendorId(vName);
				t.setItemName(iName);
				t.setAmount(itemPrice);
				t.setCardNumber(trans.getCardNumber());
				t.setCvv(trans.getCvv());
				t.setExpdate(trans.getExpdate());
				t.setUserid(u.getId());
				t.setTransactiondate(new Date().toString());
				
				transactionRepository.save(t);
			} 
			else
			{
				throw new PaymentFailedException("Payment failed at payment service");
			}
		}
		else
		{
			throw new UserNotFoundException("There is no user with given details. So could not place order");
		}
		
		
			}

	
}
