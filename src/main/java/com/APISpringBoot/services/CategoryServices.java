package com.APISpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APISpringBoot.dto.CategoryDto;
import com.APISpringBoot.models.CategoryModel;
import com.APISpringBoot.repositories.CategoryRepository;


@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryDto> findAll() {
		List<CategoryModel> cat = categoryRepository.findAll();
		List<CategoryDto> dto = cat.stream().map(x -> new CategoryDto(x)).toList();
		return dto;
	}


	public CategoryDto findById(Long id){
		CategoryModel cat = categoryRepository.findById(id).get();
		CategoryDto dto = new CategoryDto(cat);
		return dto;
	}
}
