package com.APISpringBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.APISpringBoot.models.OrderModel;
import com.APISpringBoot.models.UserModel;
import com.APISpringBoot.repositories.OrderRepository;
import com.APISpringBoot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		UserModel u1 = new UserModel(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null);
		UserModel u2 = new UserModel(null, "Alex Green", "alex@gmail.com", "977777777", "123456", null);
		OrderModel o1 = new OrderModel(null, Instant.parse("2019-06-20T19:53:07Z"), null, u1, null, null);
		OrderModel o2 = new OrderModel(null, Instant.parse("2019-07-21T03:42:10Z"), null, u2, null, null);
		OrderModel o3 = new OrderModel(null, Instant.parse("2019-07-21T03:42:10Z"), null, u1, null, null);

		userRepository.saveAll(Arrays.asList(u1, u2));

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
