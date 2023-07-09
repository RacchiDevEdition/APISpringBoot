package com.APISpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APISpringBoot.models.PaymentModel;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

}
