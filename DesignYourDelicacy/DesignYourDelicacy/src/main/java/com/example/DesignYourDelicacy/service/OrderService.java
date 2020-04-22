package com.example.DesignYourDelicacy.service;

import java.util.List;

import com.example.DesignYourDelicacy.entity.OrderDetails;
import com.example.DesignYourDelicacy.entity.Transaction;

public interface OrderService {

	void orderItems(String vendorName, String[] varString);

	void orderFood(Transaction trans, int itemPrice,String vname,String iName);

	//List<OrderDetails> fetchOrdersForUser(int userId);

}
