package com.potatorestaurant.single.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.domain.repository.ICustomerOrderRepository;

@Service
public class CustomerOrderService {
	
	@Autowired
	ICustomerOrderRepository customerOrderRepository;
	
	
	

}
