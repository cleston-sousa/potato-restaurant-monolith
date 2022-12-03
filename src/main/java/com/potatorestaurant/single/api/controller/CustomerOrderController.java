package com.potatorestaurant.single.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.potatorestaurant.single.api.controller.openapi.CustomerOrderControllerOpenApi;
import com.potatorestaurant.single.api.dto.CustomerOrderCreateRequest;
import com.potatorestaurant.single.api.dto.CustomerOrderEditRequest;
import com.potatorestaurant.single.api.dto.CustomerOrderResponse;
import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.CustomerOrderStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerOrder;
import com.potatorestaurant.single.domain.service.CustomerOrderService;

@RestController
@RequestMapping("/customer-order")
public class CustomerOrderController implements CustomerOrderControllerOpenApi {

	@Autowired
	CustomerOrderService customerOrderService;

	@GetMapping
	public List<CustomerOrderResponse> listAll() {
		List<CustomerOrder> result = customerOrderService.listAll(null, null);
		return ModelMapperUtils.mapList(result, CustomerOrderResponse.class);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerOrderResponse addOrder(@RequestBody CustomerOrderCreateRequest request) {
		return ModelMapperUtils.map(customerOrderService.create(ModelMapperUtils.map(request, CustomerOrder.class)), CustomerOrderResponse.class);
	}

	@PatchMapping("/{id}")
	public CustomerOrderResponse editOrder(@PathVariable Long id, @RequestBody CustomerOrderEditRequest request) {
		return ModelMapperUtils.map(customerOrderService.edit(id, ModelMapperUtils.map(request, CustomerOrder.class)), CustomerOrderResponse.class);
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		customerOrderService.delete(id);
	}

	@GetMapping("/awaiting")
	public List<CustomerOrderResponse> listAwaitingOrders() {
		List<CustomerOrder> result = customerOrderService.listAll(CustomerOrderStatusEnum.AWAITING, null);
		return ModelMapperUtils.mapList(result, CustomerOrderResponse.class);
	}

	@PostMapping("/delivered/{id}")
	public CustomerOrderResponse editDeliveredOrder(@PathVariable Long id) {
		CustomerOrder editOrder = new CustomerOrder();
		editOrder.setStatus(CustomerOrderStatusEnum.DELIVERED);
		return ModelMapperUtils.map(customerOrderService.edit(id, editOrder), CustomerOrderResponse.class);
	}

}
