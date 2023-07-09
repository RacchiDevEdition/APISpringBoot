package com.APISpringBoot.models;

import java.io.Serializable;
import java.util.Objects;

import com.APISpringBoot.models.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItemModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	private Integer quantity;
	private Double price;
	
	public OrderItemModel() {
		
	}
	
	public OrderItemModel(OrderModel order, ProductModel product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	
	@JsonIgnore
	public OrderModel getOrder() {
		return id.getOrder();
	}

	public void setOrder(OrderModel order) {
		id.setOrder(order);
	}

	public ProductModel getProduct() {
		return id.getProduct();
	}

	public void setProduct(ProductModel product) {
		id.setProduct(product);
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

	public double getsubTotal() {
		return quantity * price;
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
		OrderItemModel other = (OrderItemModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
