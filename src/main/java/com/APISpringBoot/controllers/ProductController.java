package com.APISpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APISpringBoot.dto.ProductDto;
import com.APISpringBoot.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> findAll(){
		List<ProductDto> dto = productServices.findAll();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/(id)")
	public ResponseEntity <List<ProductDto>> findByid(@PathVariable Long id){
		List<ProductDto> dto = productServices.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
