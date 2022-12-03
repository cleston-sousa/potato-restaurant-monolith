package com.potatorestaurant.single.domain.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.CustomerOrderStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerOrder;
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

	public CustomerOrder create(CustomerOrder newOrder) {
		
		newOrder.getAddIngredient().forEach(item -> item.getIngredientId().setCustomerOrder(newOrder));
		newOrder.getRemoveIngredient().forEach(item -> item.getIngredientId().setCustomerOrder(newOrder));
		
		newOrder.setStatus(CustomerOrderStatusEnum.AWAITING);

		CustomerOrder result = customerOrderRepository.save(newOrder);
		
		return result;
	}
	
	@Transactional
	public CustomerOrder edit(Long orderId, CustomerOrder editOrder) {
		CustomerOrder order = customerOrderRepository.findById(orderId).orElseThrow();
		editOrder.setAddIngredient(null);
		editOrder.setRemoveIngredient(null);
		ModelMapperUtils.map(editOrder, order);
		CustomerOrder result = customerOrderRepository.save(order);
		return result;
	}

	@Transactional
	public void delete(Long id) {
		CustomerOrder order = customerOrderRepository.findById(id).orElseThrow();
		customerOrderRepository.delete(order);
	}

}
