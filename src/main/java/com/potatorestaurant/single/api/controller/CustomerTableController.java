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

import com.potatorestaurant.single.api.controller.openapi.CustomerTableControllerOpenApi;
import com.potatorestaurant.single.api.dto.CustomerTableCreateRequest;
import com.potatorestaurant.single.api.dto.CustomerTableEditRequest;
import com.potatorestaurant.single.api.dto.CustomerTableEditStatusRequest;
import com.potatorestaurant.single.api.dto.CustomerTableResponse;
import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.CustomerTableStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerTable;
import com.potatorestaurant.single.domain.service.CustomerTableService;

@RestController
@RequestMapping("/customer-tables")
public class CustomerTableController implements CustomerTableControllerOpenApi {

	@Autowired
	CustomerTableService customerTableService;

	@GetMapping
	public List<CustomerTableResponse> listAllTables() {
		List<CustomerTable> result = customerTableService.listAll();
		List<CustomerTableResponse> response = ModelMapperUtils.mapList(result, CustomerTableResponse.class);
		return response;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerTableResponse addTable(@RequestBody CustomerTableCreateRequest request) {
		CustomerTable toCreate = ModelMapperUtils.map(request, CustomerTable.class);
		CustomerTable result = customerTableService.create(toCreate);
		CustomerTableResponse response = ModelMapperUtils.map(result, CustomerTableResponse.class);
		return response;
	}

	@PatchMapping("/{id}")
	public CustomerTableResponse editTable(@PathVariable Long id, @RequestBody CustomerTableEditRequest request) {
		CustomerTable toEdit = ModelMapperUtils.map(request, CustomerTable.class);
		CustomerTable result = customerTableService.edit(id, toEdit);
		CustomerTableResponse response = ModelMapperUtils.map(result, CustomerTableResponse.class);
		return response;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteTable(@PathVariable Long id) {
		customerTableService.delete(id);
	}

	@PostMapping("/status/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editTableStatus(@PathVariable Long id, @RequestBody CustomerTableEditStatusRequest request) {
		CustomerTable toEdit = ModelMapperUtils.map(request, CustomerTable.class);
		customerTableService.edit(id, toEdit);
	}

	@PostMapping("/start-service/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void startTableService(@PathVariable Long id) {
		customerTableService.editStatus(id, CustomerTableStatusEnum.OCCUPIED);

	}

	@PostMapping("/stop-service/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void stopTableService(@PathVariable Long id) {
		customerTableService.editStatus(id, CustomerTableStatusEnum.PAYMENT);
	}

}
