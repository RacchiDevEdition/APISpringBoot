package com.APISpringBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.APISpringBoot.models.CategoryModel;
import com.APISpringBoot.models.OrderItemModel;
import com.APISpringBoot.models.OrderModel;
import com.APISpringBoot.models.ProductModel;
import com.APISpringBoot.models.UserModel;
import com.APISpringBoot.models.enums.OrderStatus;
import com.APISpringBoot.repositories.CategoryRepository;
import com.APISpringBoot.repositories.OrderItemRepository;
import com.APISpringBoot.repositories.OrderRepository;
import com.APISpringBoot.repositories.ProductRepository;
import com.APISpringBoot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		 CategoryModel cat1 = new  CategoryModel(null, "Electronics");
		 CategoryModel cat2 = new CategoryModel(null, "Books");
		 CategoryModel cat3 = new  CategoryModel(null, "Computers");
		
		ProductModel p1 = new ProductModel(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		ProductModel p2 = new ProductModel(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		ProductModel p3 = new ProductModel(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		ProductModel p4 = new ProductModel(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		ProductModel p5 = new ProductModel(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		UserModel u1 = new UserModel(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		UserModel u2 = new UserModel(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		OrderModel o1 = new OrderModel(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		OrderModel o2 = new OrderModel(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		OrderModel o3 = new OrderModel(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItemModel oi1 = new OrderItemModel(o1, p1, 2, p1.getPrice());
		OrderItemModel oi2 = new OrderItemModel(o1, p3, 1, p3.getPrice());
		OrderItemModel oi3 = new OrderItemModel(o2, p3, 2, p3.getPrice());
		OrderItemModel oi4 = new OrderItemModel(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));	
	
	}

}
