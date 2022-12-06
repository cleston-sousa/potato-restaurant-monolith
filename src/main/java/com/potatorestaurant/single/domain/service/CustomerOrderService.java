package com.potatorestaurant.single.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.CustomIngredientActionEnum;
import com.potatorestaurant.single.domain.enums.CustomerOrderStatusEnum;
import com.potatorestaurant.single.domain.model.CustomIngredient;
import com.potatorestaurant.single.domain.model.CustomerOrder;
import com.potatorestaurant.single.domain.model.MenuItem;
import com.potatorestaurant.single.domain.repository.ICustomerOrderRepository;
import com.potatorestaurant.single.domain.repository.ICustomerTableRepository;
import com.potatorestaurant.single.domain.repository.IMenuItemRepository;

@Service
public class CustomerOrderService {

	@Autowired
	ICustomerOrderRepository customerOrderRepository;

	@Autowired
	IMenuItemRepository menuItemRepository;

	@Autowired
	ICustomerTableRepository customerTableRepository;

	public List<CustomerOrder> listAll(CustomerOrderStatusEnum status) {
		if (Objects.nonNull(status))
			return customerOrderRepository.findAllByStatus(status);
		return customerOrderRepository.findAll();
	}

	public CustomerOrder create(CustomerOrder newOrder) {
		
		final var cusomterTable = customerTableRepository.findById(newOrder.getCustomerTableId()).orElseThrow();
		final var menuItem = menuItemRepository.findById(newOrder.getMenuItemId()).orElseThrow();
		
		newOrder.setId(null);
		newOrder.setCustomerTableName(cusomterTable.getName());
		newOrder.setMenuItemName(menuItem.getName());
		
		var totalPrice = menuItem.getPrice();

		var ingredientsPrice = newOrder.getCustomIngredient().stream().map(item -> sumIgredients(item, newOrder, menuItem))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		newOrder.setPrice(totalPrice.add(ingredientsPrice));
		
		newOrder.setStatus(CustomerOrderStatusEnum.AWAITING);
		
		CustomerOrder result = customerOrderRepository.save(newOrder);
		
		return result;
	}
	
	public BigDecimal sumIgredients(CustomIngredient item, CustomerOrder newOrder, MenuItem menuItem) {
		
		var ingredients = menuItem.getIngredients();
		
		final var ingredient = ingredients.stream().filter(listIngredient -> item.getIngredientId().equals(listIngredient.getId())).findFirst().orElseThrow();

		item.setId(null);
		item.setIngredientName(ingredient.getName());
		item.setCustomerOrder(newOrder);

		if (CustomIngredientActionEnum.ADD.equals(item.getAction())) {
			item.setPrice(ingredient.getPrice());
		} else {
			item.setPrice(BigDecimal.ZERO);
		}

		return item.getPrice();
	}
	
	@Transactional
	public CustomerOrder edit(Long orderId, CustomerOrder editOrder) {
		CustomerOrder order = customerOrderRepository.findById(orderId).orElseThrow();
		editOrder.setCustomIngredient(null);
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
