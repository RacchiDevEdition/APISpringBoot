package com.APISpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APISpringBoot.models.CategoryModel;


public interface CategoryRepository extends JpaRepository <CategoryModel, Long> {

}
