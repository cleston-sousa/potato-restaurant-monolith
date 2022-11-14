package com.potatorestaurant.single.api.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potatorestaurant.single.api.dto.CustomerOrderResponse;

@RestController
@RequestMapping("/customer-order")
public class CustomerOrderController {

	@GetMapping
	public List<CustomerOrderResponse> listAll() {
		return Collections.emptyList();
	}

	@PostMapping
	public CustomerOrderResponse addOrder() {
		return new CustomerOrderResponse();
	}

	@PatchMapping("/{id}")
	public CustomerOrderResponse editOrder() {
		return new CustomerOrderResponse();
	}

	@DeleteMapping("/{id}")
	public void deleteOrder() {
	}

	@GetMapping("/awaiting")
	public List<CustomerOrderResponse> listAwaitingOrders() {
		return Collections.emptyList();
	}

	@PostMapping("/delivered/{id}")
	public void editDeliveredOrder() {
	}

}
