package com.APISpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APISpringBoot.models.OrderItemModel;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, Long> {

}
