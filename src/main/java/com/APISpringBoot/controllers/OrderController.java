package com.APISpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APISpringBoot.dto.OrderDto;
import com.APISpringBoot.services.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	public OrderServices orderService;

	@GetMapping
	public ResponseEntity<List<OrderDto>> findAll() {
		List<OrderDto> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<List<OrderDto>> findById(@PathVariable Long id) {
		List<OrderDto> dto = orderService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
