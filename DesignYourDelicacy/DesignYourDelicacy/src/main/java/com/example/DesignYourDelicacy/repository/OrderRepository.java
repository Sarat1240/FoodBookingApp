package com.example.DesignYourDelicacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.DesignYourDelicacy.entity.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {
	
	@Query("select t from OrderDetails t where t.id=?1")
	List<OrderDetails> getlatestOrders(int userId);

}
