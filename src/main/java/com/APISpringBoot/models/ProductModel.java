package com.APISpringBoot.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class ProductModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	private OrderModel orders;
	private CategoryModel categories;

	public ProductModel(Long id, String name, String description, Double price, String imgUrl, OrderModel orders,
			CategoryModel categories) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.orders = orders;
		this.categories = categories;
	}

	public ProductModel() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public OrderModel getOrders() {
		return orders;
	}

	public CategoryModel getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categories, description, id, imgUrl, name, orders, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductModel other = (ProductModel) obj;
		return Objects.equals(categories, other.categories) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(name, other.name) && Objects.equals(orders, other.orders)
				&& Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imgUrl=" + imgUrl + ", orders=" + orders + ", categories=" + categories + "]";
	}

}
