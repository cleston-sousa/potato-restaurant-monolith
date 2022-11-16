package com.potatorestaurant.single.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.domain.enums.MenuItemStatusEnum;
import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.MenuItem;
import com.potatorestaurant.single.domain.repository.IMenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	IMenuItemRepository menuItemRepository;
	
	

	@Autowired
	MenuCategoryService menuCategoryService;
	
	
	@Autowired
	IngredientService ingredientService;

	public List<MenuItem> listAll(MenuItemStatusEnum status) {
		if (status != null)
			menuItemRepository.findAllByStatus(status);
		return menuItemRepository.findAll();
	}

	public MenuItem create(Long menuCategory, String name, String description, BigDecimal price, List<Ingredient> listIngredients) {
		MenuItem newItem = new MenuItem();

		if (menuCategory != null)
			newItem.setMenuCategory(menuCategoryService.getById(menuCategory));

		if (StringUtils.isNotBlank(name))
			newItem.setName(name);

		if (StringUtils.isNotBlank(description))
			newItem.setDescription(description);

		if (price != null && price.compareTo(BigDecimal.ZERO) > 0)
			newItem.setPrice(price);

		newItem.setStatus(MenuItemStatusEnum.DISABLED);

		MenuItem result = menuItemRepository.save(newItem);

		if (listIngredients != null && listIngredients.size() > 0) {
			for (Ingredient ingredient : listIngredients) {
				ingredientService.create(result, ingredient.getName(), ingredient.getDescription(), ingredient.isIncluded(), ingredient.getPrice());
			}
		}

		return result;

	}

	public MenuItem edit(Long id, Long menuCategory, String name, String description, BigDecimal price, MenuItemStatusEnum status, List<Ingredient> listIngredients) {
		MenuItem item = menuItemRepository.findById(id)
				.orElseThrow();

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

}
