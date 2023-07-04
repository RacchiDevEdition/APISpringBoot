package com.APISpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APISpringBoot.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
