package com.APISpringBoot.models.pk;


import com.APISpringBoot.models.OrderModel;
import com.APISpringBoot.models.ProductModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;


@Embeddable
public class OrderItemPK {
	@ManyToOne
	private ProductModel product;
	
	@ManyToOne
	private OrderModel order;

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}
	
	
}
