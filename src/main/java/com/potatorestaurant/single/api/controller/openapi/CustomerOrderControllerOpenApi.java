package com.potatorestaurant.single.api.controller.openapi;

import java.util.List;

import com.potatorestaurant.single.api.dto.CustomerOrderCreateRequest;
import com.potatorestaurant.single.api.dto.CustomerOrderEditRequest;
import com.potatorestaurant.single.api.dto.CustomerOrderResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Customer orders", description = "Manage customer orders")
public interface CustomerOrderControllerOpenApi {

	@ApiOperation(value = "List all orders")
	List<CustomerOrderResponse> listAll();

	@ApiOperation(value = "Place a order")
	@ApiResponses({ @ApiResponse(code = 201, message = "Order successfully placed"), })
	CustomerOrderResponse addOrder(@ApiParam(name = "request", value = "New customer order model") CustomerOrderCreateRequest request);

	@ApiOperation(value = "Edit a order")
	CustomerOrderResponse editOrder(@ApiParam(value = "Order id", example = "1", required = true) Long id,
			@ApiParam(name = "request", value = "Edit customer order model") CustomerOrderEditRequest request);

	@ApiOperation(value = "Remove a order")
	void deleteOrder(@ApiParam(value = "Order id", example = "1", required = true) Long id);

	@ApiOperation(value = "List all awaiting orders")
	List<CustomerOrderResponse> listAwaitingOrders();

	@ApiOperation(value = "Chance order status to DELIVERED")
	CustomerOrderResponse editDeliveredOrder(@ApiParam(value = "Order id", example = "1", required = true) Long id);

}