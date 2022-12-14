package com.potatorestaurant.single.api.controller;

import java.util.ArrayList;
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

import com.potatorestaurant.single.api.dto.CustomerTableCreateRequest;
import com.potatorestaurant.single.api.dto.CustomerTableEditRequest;
import com.potatorestaurant.single.api.dto.CustomerTableResponse;
import com.potatorestaurant.single.domain.enums.CustomerTableStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerTable;
import com.potatorestaurant.single.domain.service.CustomerTableService;

@RestController
@RequestMapping("/customer-tables")
public class CustomerTableController {

	@Autowired
	CustomerTableService customerTableService;

	@GetMapping
	public List<CustomerTableResponse> listAllTables() {

		List<CustomerTable> result = customerTableService.listAll();

		List<CustomerTableResponse> response = new ArrayList<>();

		for (CustomerTable resultItem : result) {

			CustomerTableResponse responseItem = new CustomerTableResponse();

			responseItem.setId(resultItem.getId());
			responseItem.setName(resultItem.getName());
			responseItem.setStatus(resultItem.getStatus().ordinal());
			responseItem.setStatusDescription(resultItem.getStatus().name());

			response.add(responseItem);
		}

		return response;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerTableResponse addTable(@RequestBody CustomerTableCreateRequest request) {

		CustomerTable result = customerTableService.create(request.getName());

		CustomerTableResponse response = new CustomerTableResponse();

		response.setId(result.getId());
		response.setName(result.getName());
		response.setStatus(result.getStatus().ordinal());
		response.setStatusDescription(result.getStatus().name());

		return response;
	}

	@PatchMapping("/{id}")
	public CustomerTableResponse editTable(@PathVariable Long id, @RequestBody CustomerTableEditRequest request) {

		CustomerTable result = customerTableService.edit(id, request.getName(),
				CustomerTableStatusEnum.get(request.getStatus()));

		CustomerTableResponse response = new CustomerTableResponse();

		response.setId(result.getId());
		response.setName(result.getName());
		response.setStatus(result.getStatus().ordinal());
		response.setStatusDescription(result.getStatus().name());

		return response;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteTable(@PathVariable Long id) {
		customerTableService.delete(id);
	}

	@PostMapping("/status/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editTableStatus(@PathVariable Long id, @RequestBody CustomerTableEditRequest request) {
		customerTableService.edit(id, null, CustomerTableStatusEnum.get(request.getStatus()));
	}

	@PostMapping("/start-service/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void startTableService(@PathVariable Long id) {
		customerTableService.edit(id, null, CustomerTableStatusEnum.OCCUPIED);

	}

	@PostMapping("/stop-service/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void stopTableService(@PathVariable Long id) {
		customerTableService.edit(id, null, CustomerTableStatusEnum.PAYMENT);
	}

}
