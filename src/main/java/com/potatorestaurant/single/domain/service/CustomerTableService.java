package com.potatorestaurant.single.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.CustomerTableStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerTable;
import com.potatorestaurant.single.domain.repository.ICustomerTableRepository;

@Service
public class CustomerTableService {

	@Autowired
	ICustomerTableRepository customerTableRepository;

	public List<CustomerTable> listAll() {
		return customerTableRepository.findAll();
	}

	public CustomerTable create(CustomerTable newCustomerTable) {
		newCustomerTable.setStatus(CustomerTableStatusEnum.AVAILABLE);
		return customerTableRepository.save(newCustomerTable);
	}

	public CustomerTable edit(Long id, CustomerTable editCustomerTable) {
		CustomerTable customerTable = customerTableRepository.findById(id).orElseThrow();
		ModelMapperUtils.map(editCustomerTable, customerTable);
		return customerTableRepository.save(customerTable);
	}

	public CustomerTable editStatus(Long id, CustomerTableStatusEnum status) {
		CustomerTable customerTable = customerTableRepository.findById(id).orElseThrow();
		customerTable.setStatus(status);
		return customerTableRepository.save(customerTable);
	}

	public void delete(Long id) {
		CustomerTable customerTable = customerTableRepository.findById(id).orElseThrow();
		customerTableRepository.delete(customerTable);
	}
}
