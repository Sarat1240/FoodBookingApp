package com.example.DesignYourDelicacy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DesignYourDelicacy.dto.TransactionRequest;
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
	public long orderFood(TransactionRequest transReq, int itemPrice, String vName, String iName) {
		
		Transaction  transactionEntity = convertReqToEntity(transReq);
		OrderDetails order = new OrderDetails();
		int orderId;
		Optional<User> user = userRepository.findById((int) transactionEntity.getUserid());
		if (user.isPresent()) {
			User u = user.get();
			transactionEntity.setPrice(itemPrice);
			ResponseEntity<Transaction> res = bankingFeignClient.debitAccount(transactionEntity);
			System.out.println("--------------------------------------------------------");
			System.out.println("Transaction Object in Food Booking App:" + res);
			System.out.println("--------------------------------------------------------");
			if (res.getBody().getTid() != 0) {
				System.out.println("Transaction in Order Service:" + transactionEntity);

				order.setItemName(iName);
				order.setOrderAmount(itemPrice);
				order.setVendor(vName);
				order.setOrderDate(new Date().toString());

				ArrayList<OrderDetails> olist = new ArrayList<OrderDetails>();
				olist.add(order);
				u.setOrderList(olist);
				order.setUser(u);

				User u1 = userRepository.save(u);
				System.out.println("Order ID:"+u1.getOrderList().get(0).getOrderId());
				orderId = u1.getOrderList().get(0).getOrderId();
				// order.setUser(user);
				// OrderDetails savedOrder = orderRepository.save(order);
				/*
				 * if(savedOrder!=null) { Transaction t = new Transaction(); t.set }
				 */

				Transaction t = new Transaction();
				t.setVendorId(vName);
				t.setItemName(iName);
				t.setPrice(itemPrice);
				t.setCardNumber(transactionEntity.getCardNumber());
				t.setCvv(transactionEntity.getCvv());
				t.setExpdate(transactionEntity.getExpdate());
				t.setUserid(u.getId());
				t.setTransactiondate(new Date().toString());

				 transactionRepository.save(t);
			} else {
				throw new PaymentFailedException("Payment failed at payment service");
			}
		} else {
			throw new UserNotFoundException("There is no user with given details. So could not place order");
		}
		return orderId;
	}

	@Override
	public List<OrderDetails> getlatestOrders(int userId) {
		// TODO Auto-generated method stub
		return orderRepository.getlatestOrders(userId);
	}
	
	public Transaction convertReqToEntity(TransactionRequest treq)
	{
		Transaction transaction = new Transaction();
		transaction.setCardNumber(treq.getCardNumber());
		transaction.setCvv(treq.getCvv());
		transaction.setExpdate(treq.getExpdate());
		transaction.setUserid(treq.getUserid());
		return transaction;
	}

}
