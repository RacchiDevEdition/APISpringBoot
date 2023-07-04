package com.APISpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APISpringBoot.dto.UserDto;
import com.APISpringBoot.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserServices userServices;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> list = userServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <List<UserDto>> findById(@PathVariable Long id) {
		List<UserDto> dto = userServices.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
