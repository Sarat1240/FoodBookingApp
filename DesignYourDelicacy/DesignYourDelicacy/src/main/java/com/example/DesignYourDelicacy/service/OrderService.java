package com.example.DesignYourDelicacy.service;

import java.util.List;

import com.example.DesignYourDelicacy.dto.TransactionRequest;
import com.example.DesignYourDelicacy.entity.OrderDetails;
import com.example.DesignYourDelicacy.entity.Transaction;

public interface OrderService {

	void orderItems(String vendorName, String[] varString);

	long orderFood(TransactionRequest transReq, int itemPrice,String vname,String iName);

	List<OrderDetails> getlatestOrders(int userId);

	//List<OrderDetails> fetchOrdersForUser(int userId);

}
