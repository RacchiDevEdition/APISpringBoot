package com.APISpringBoot.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.APISpringBoot.models.OrderModel;
import com.APISpringBoot.models.PaymentModel;
import com.APISpringBoot.models.UserModel;
import com.APISpringBoot.models.enums.OrderStatus;

public class OrderDto {

	private OrderModel order;
	private Long id;
	private Instant moment;
	private OrderStatus orderStatus;
	private UserModel client;
	private Set<OrderItemDto> items = new HashSet<>();
	private PaymentModel payment;

	public OrderDto(OrderModel order) {
		this.id = order.getId();
		this.moment = order.getMoment();
		this.orderStatus = order.getOrderStatus();
		this.client = order.getClient();
		this.payment = order.getPayment();
	}
	
	public OrderDto() {
		
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UserModel getClient() {
		return client;
	}

	public void setClient(UserModel client) {
		this.client = client;
	}

	public Set<OrderItemDto	> getItems() {
		return items;
	}

	

	public PaymentModel getPayment() {
		return payment;
	}

	public void setPayment(PaymentModel payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		return Objects.equals(id, other.id);
	}

}
