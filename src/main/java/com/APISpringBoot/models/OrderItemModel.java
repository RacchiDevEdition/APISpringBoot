package com.APISpringBoot.models;

public class OrderItemModel {

	private Integer quantity;
	private Double price;
	
	
	public double subTotal() {
		return quantity * price;
	}
}
