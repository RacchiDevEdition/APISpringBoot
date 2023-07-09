package com.APISpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APISpringBoot.dto.ProductDto;
import com.APISpringBoot.models.ProductModel;
import com.APISpringBoot.repositories.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDto> findAll()	{
		List<ProductModel> list = productRepository.findAll();	
		List<ProductDto> dto = list.stream().map(x -> new ProductDto()).toList();
		return dto;
	}

	public List<ProductDto> findById(Long id) {
		Optional<ProductModel> productById = productRepository.findById(id);
		List<ProductDto> dto = productById.stream().map(x -> new ProductDto()).toList();
		return dto;
	}
}
