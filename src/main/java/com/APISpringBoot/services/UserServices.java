package com.APISpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APISpringBoot.dto.UserDto;
import com.APISpringBoot.models.UserModel;
import com.APISpringBoot.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;

	public List<UserDto> findAll() {
		List<UserModel> result = userRepository.findAll();
		List<UserDto> dto = result.stream().map(x -> new UserDto(x)).toList();
		return dto;
	}

	public List<UserDto> findById(Long id) {
		Optional<UserModel> userById = userRepository.findById(id);
		List<UserDto> dto = userById.stream().map(x -> new UserDto(x)).toList();
		return dto;
	}

}
