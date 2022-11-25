package com.potatorestaurant.single.domain.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.domain.enums.CustomerOrderStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerOrder;
import com.potatorestaurant.single.domain.model.CustomerTable;
import com.potatorestaurant.single.domain.model.MenuItem;
import com.potatorestaurant.single.domain.repository.ICustomerOrderRepository;
import com.potatorestaurant.single.domain.repository.ICustomerTableRepository;
import com.potatorestaurant.single.domain.repository.IIngredientRepository;
import com.potatorestaurant.single.domain.repository.IMenuItemRepository;

@Service
public class CustomerOrderService {

	@Autowired
	ICustomerOrderRepository customerOrderRepository;

	@Autowired
	IMenuItemRepository menuItemRepository;

	@Autowired
	IIngredientRepository ingredientRepository;

	@Autowired
	ICustomerTableRepository customerTableRepository;

	public List<CustomerOrder> listAll(CustomerOrderStatusEnum status, Long customerTableId) {

		if (Objects.nonNull(customerTableId) && Objects.nonNull(status))
			return customerOrderRepository.findAllByStatusAndCustomerTableId(status, customerTableId);

		if (Objects.nonNull(customerTableId))
			return customerOrderRepository.findAllByCustomerTableId(customerTableId);

		if (Objects.nonNull(status))
			return customerOrderRepository.findAllByStatus(status);

		return customerOrderRepository.findAll();
	}

	public CustomerOrder addOrder(CustomerOrder newOrder) {

		//TODO here
			
			
		CustomerOrder result = customerOrderRepository.save(newOrder);
		
		return result;
	}
	
	
}
