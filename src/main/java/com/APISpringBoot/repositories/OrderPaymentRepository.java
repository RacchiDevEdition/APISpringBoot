package com.APISpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APISpringBoot.models.OrderPaymentModel;

public interface OrderPaymentRepository extends JpaRepository<OrderPaymentModel, Long> {

}
