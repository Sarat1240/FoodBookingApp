package com.example.DesignYourDelicacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DesignYourDelicacy.entity.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}
