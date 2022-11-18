package com.potatorestaurant.single.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.MenuItemStatusEnum;
import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.MenuItem;
import com.potatorestaurant.single.domain.repository.IIngredientRepository;
import com.potatorestaurant.single.domain.repository.IMenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	IMenuItemRepository menuItemRepository;

	@Autowired
	IIngredientRepository ingredientRepository;

	public List<MenuItem> listAll(MenuItemStatusEnum status) {
		if (status != null)
			menuItemRepository.findAllByStatus(status);
		return menuItemRepository.findAll();
	}

	public MenuItem create(MenuItem newItem) {
		newItem.setId(null);
		newItem.setStatus(MenuItemStatusEnum.DISABLED);
		MenuItem result = menuItemRepository.save(newItem);
		return result;
	}
	
	public MenuItem addIngredient(Long id, MenuItem newItem) {
		MenuItem item = menuItemRepository.findById(id).orElseThrow();

		
		
		
		if (newItem.getIngredients() != null && newItem.getIngredients().size() > 0) {
			for (Ingredient ingredient : newItem.getIngredients()) {
				ingredient.setMenuItem(newItem);
			}
		}
		MenuItem result = menuItemRepository.save(newItem);
		return result;
	}

	public MenuItem edit(Long id, MenuItem editItem) {
		MenuItem item = menuItemRepository.findById(id).orElseThrow();
		ModelMapperUtils.map(editItem, item);
		MenuItem result = menuItemRepository.save(item);
		return result;
	}

/*
	public MenuItem edit(Long id, Long menuCategory, String name, String description, BigDecimal price, MenuItemStatusEnum status, List<Ingredient> listIngredients) {
		MenuItem item = menuItemRepository.findById(id).orElseThrow();

		if (menuCategory != null)
			item.setMenuCategory(menuCategoryService.getById(menuCategory));

		if (StringUtils.isNotBlank(name))
			item.setName(name);

		if (StringUtils.isNotBlank(description))
			item.setDescription(description);

		if (price != null && price.compareTo(BigDecimal.ZERO) > 0)
			item.setPrice(price);

		if (status != null)
			item.setStatus(status);

		ingredientService.deleteAll(item);

		if (listIngredients != null && listIngredients.size() > 0) {
			for (Ingredient ingredient : listIngredients) {
				ingredientService.create(item, ingredient.getName(), ingredient.getDescription(), ingredient.isIncluded(), ingredient.getPrice());
			}
		}

		return menuItemRepository.save(item);

	}

	public void delete(Long id) {
		MenuItem item = menuItemRepository.findById(id).orElseThrow();
		menuItemRepository.delete(item);

	}
*/
}
