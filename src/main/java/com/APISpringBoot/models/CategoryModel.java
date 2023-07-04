package com.APISpringBoot.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category")
public class CategoryModel implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private ProductModel products;

	public CategoryModel(String name, ProductModel products) {
		this.name = name;
		this.products = products;
	}

	public CategoryModel() {

	}

	public String getName() {
		return name;
	}

	public ProductModel getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryModel other = (CategoryModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(products, other.products);
	}

	@Override
	public String toString() {
		return "CategoryModel [name=" + name + ", products=" + products + "]";
	}

}
