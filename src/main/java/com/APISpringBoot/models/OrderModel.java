package com.APISpringBoot.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.APISpringBoot.models.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date moment;
	private OrderStatus orderStatus;
	private UserModel client;
	private ProductModel items;
	private OrderPaymentModel payment;
	

	public double total() {
		return 0;
	}
	
}
