package com.APISpringBoot.models;

import java.io.Serializable;
import java.time.Instant;

import com.APISpringBoot.dto.OrderDto;
import com.APISpringBoot.models.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class OrderModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private OrderStatus orderStatus;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private UserModel client;
	private ProductModel items;
	private OrderPaymentModel payment;

	public OrderModel(Long id, Instant moment, OrderStatus orderStatus, UserModel client, ProductModel items,
			OrderPaymentModel payment) {
		super();
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
		this.items = items;
		this.payment = payment;
	}

	public OrderModel(OrderDto dto) {
		
	}

	public OrderModel() {

	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public UserModel getClient() {
		return client;
	}

	public ProductModel getItems() {
		return items;
	}

	public OrderPaymentModel getPayment() {
		return payment;
	}

	public double total() {
		return 0;
	}

}
