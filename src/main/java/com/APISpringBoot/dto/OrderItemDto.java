package com.APISpringBoot.dto;

import com.APISpringBoot.models.OrderItemModel;

public class OrderItemDto {

	private OrderItemModel orderItem;
	private Integer quantity;
	private Double price;

	public OrderItemDto(OrderItemModel orderItem) {
		orderItem.getOrder();
		orderItem.getProduct();
		this.quantity = orderItem.getQuantity();
		this.price = orderItem.getPrice();

	}

	public OrderItemDto() {

	}

	public OrderItemModel getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItemModel orderItem) {
		this.orderItem = orderItem;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
