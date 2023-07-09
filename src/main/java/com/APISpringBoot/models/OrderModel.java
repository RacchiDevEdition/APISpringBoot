package com.APISpringBoot.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.APISpringBoot.dto.OrderDto;
import com.APISpringBoot.models.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	private Integer orderStatus;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private UserModel client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItemModel> items = new HashSet<>();
	

	@OneToOne(mappedBy = "order" , cascade = CascadeType.ALL)
	private PaymentModel payment;

	public OrderModel(Long id, Instant moment, OrderStatus orderStatus, UserModel client) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
		

	}

	public OrderModel(OrderDto dto) {

		this.id = dto.getId();
		this.moment = dto.getMoment();
		this.setOrderStatus(getOrderStatus());
		this.client = dto.getClient();
		this.payment = dto.getPayment();
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
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	public UserModel getClient() {
		return client;
	}

	public Set<OrderItemModel> getItems() {
		return items;
	}

	public PaymentModel getPayment() {
		return payment;
	}

	public double total() {
		return 0;
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
		OrderModel other = (OrderModel) obj;
		return Objects.equals(id, other.id);
	}
}
