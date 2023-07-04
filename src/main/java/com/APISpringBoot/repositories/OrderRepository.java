package com.APISpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APISpringBoot.models.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Long>{

}
