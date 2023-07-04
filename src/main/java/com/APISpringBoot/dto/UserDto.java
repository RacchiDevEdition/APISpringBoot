package com.APISpringBoot.dto;

import java.util.Objects;

import com.APISpringBoot.models.UserModel;

public class UserDto {

	private Long id;
	private String name;
	private Object email;
	private Object phone;
	private Object orders;
	private String password;

	public UserDto(UserModel user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.password = user.getPassword();
		this.orders = user.getOrders();
	}

	public UserDto() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Object getEmail() {
		return email;
	}

	public Object getPhone() {
		return phone;
	}

	public Object getOrders() {
		return orders;
	}

	public String getPassword() {
		return password;
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
		UserDto other = (UserDto) obj;
		return Objects.equals(id, other.id);
	}

}
