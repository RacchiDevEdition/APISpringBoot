package com.APISpringBoot.dto;

import java.util.Set;

import com.APISpringBoot.models.ProductModel;

public class ProductDto {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	private Set<OrderItemDto> product;
	private Set<CategoryDto> categories; 
	
	public ProductDto(ProductModel product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.imgUrl = product.getImgUrl();
	}

	public ProductDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<CategoryDto> getCategories() {
		return categories;
	}

	public Set<OrderItemDto> getItems() {
		return product;
	}


}
