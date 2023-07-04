package com.APISpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APISpringBoot.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
