package com.potatorestaurant.single.domain.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public CustomerTable create(String name) {
		CustomerTable newCustomerTable = new CustomerTable();
		newCustomerTable.setName(name);
		newCustomerTable.setStatus(CustomerTableStatusEnum.AVAILABLE);
		return customerTableRepository.save(newCustomerTable);
	}

	public CustomerTable edit(Long id, String name, CustomerTableStatusEnum status) {
		CustomerTable customerTable = customerTableRepository.findById(id).orElseThrow();
		if (StringUtils.isNotBlank(name))
			customerTable.setName(name);
		if (status != null)
			customerTable.setStatus(status);
		return customerTableRepository.save(customerTable);
	}

	public void delete(Long id) {
		CustomerTable customerTable = customerTableRepository.findById(id).orElseThrow();
		customerTableRepository.delete(customerTable);
	}
}
