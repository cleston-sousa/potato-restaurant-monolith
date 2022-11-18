package com.potatorestaurant.single.api.controller.openapi;

import java.util.List;

import com.potatorestaurant.single.api.dto.CustomerTableCreateRequest;
import com.potatorestaurant.single.api.dto.CustomerTableEditRequest;
import com.potatorestaurant.single.api.dto.CustomerTableEditStatusRequest;
import com.potatorestaurant.single.api.dto.CustomerTableResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Customer tables", description = "Manage customer tables")
public interface CustomerTableControllerOpenApi {

	@ApiOperation(value = "List all customer tables")
	List<CustomerTableResponse> listAllTables();

	@ApiOperation(value = "Create a customer table")
	@ApiResponses({ @ApiResponse(code = 201, message = "Customer table successfully created"), })
	CustomerTableResponse addTable(@ApiParam(name = "request", value = "New customer table model") CustomerTableCreateRequest request);

	@ApiOperation(value = "Edit a customer table")
	CustomerTableResponse editTable(@ApiParam(value = "Customer table id", example = "1", required = true) Long id,
			@ApiParam(name = "request", value = "Edit customer table model") CustomerTableEditRequest request);

	@ApiOperation(value = "Delete a customer table")
	void deleteTable(@ApiParam(value = "Customer table id", example = "1", required = true) Long id);

	@ApiOperation(value = "Edit a customer table status")
	void editTableStatus(@ApiParam(value = "Customer table id", example = "1", required = true) Long id,
			@ApiParam(name = "request", value = "Status edit customer table model") CustomerTableEditStatusRequest request);

	@ApiOperation(value = "Start service to a customer table")
	void startTableService(@ApiParam(value = "Customer table id", example = "1", required = true) Long id);

	@ApiOperation(value = "Stop service to a customer table")
	void stopTableService(@ApiParam(value = "Customer table id", example = "1", required = true) Long id);

}