package com.APISpringBoot.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APISpringBoot.dto.OrderDto;
import com.APISpringBoot.models.OrderModel;
import com.APISpringBoot.repositories.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<OrderDto> findAll(){
		List<OrderModel> result = orderRepository.findAll();
		List<OrderDto> dto = result.stream().map(x -> new OrderDto(x)).toList();
		return dto;
	}


	public List<OrderDto> findById(Long id) {
		Optional<OrderModel> orderById = orderRepository.findById(id);
		List<OrderDto> dto = orderById.stream().map(x -> new OrderDto(x)).toList();
		return dto;
	}
	
}
