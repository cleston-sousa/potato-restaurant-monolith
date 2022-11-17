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

import com.potatorestaurant.single.api.dto.MenuItemCreateRequest;
import com.potatorestaurant.single.api.dto.MenuItemEditRequest;
import com.potatorestaurant.single.api.dto.MenuItemIngredientRequest;
import com.potatorestaurant.single.api.dto.MenuItemResponse;
import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.MenuItemStatusEnum;
import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.MenuItem;
import com.potatorestaurant.single.domain.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	@GetMapping
	public List<MenuItemResponse> listAll() {
		List<MenuItem> result = menuItemService.listAll(null);
		List<MenuItemResponse> response = ModelMapperUtils.mapList(result, MenuItemResponse.class);
		return response;
	}

	@PostMapping("/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MenuItemResponse addCategory(@RequestBody MenuItemCreateRequest request) {

		List<Ingredient> listIngredients = new ArrayList<>();
		for (MenuItemIngredientRequest item : request.getListIngredients()) {

			Ingredient newIngredient = new Ingredient();

			newIngredient.setName(item.getName());
			newIngredient.setDescription(item.getDescription());
			newIngredient.setIncluded(item.isIncluded());
			newIngredient.setPrice(item.getPrice());

			listIngredients.add(newIngredient);
		}

		MenuItem result = menuItemService.create(request.getMenuCategory(), request.getName(), request.getDescription(), request.getPrice(), listIngredients);

		MenuItemResponse response = new MenuItemResponse();

		response.setId(result.getId());
		response.setName(result.getName());
		response.setMenuCategory(result.getMenuCategory().getId());
		response.setMenuCategoryName(result.getMenuCategory().getName());
		response.setDescription(result.getDescription());
		response.setStatus(result.getStatus().ordinal());
		response.setStatusDescription(result.getStatus().name());
		response.setPrice(result.getPrice());

		return response;
	}

	@PatchMapping("/{id}")
	public MenuItemResponse editCategory(@PathVariable Long id, @RequestBody MenuItemEditRequest request) {

		List<Ingredient> listIngredients = new ArrayList<>();
		for (MenuItemIngredientRequest item : request.getListIngredients()) {

			Ingredient newIngredient = new Ingredient();

			newIngredient.setName(item.getName());
			newIngredient.setDescription(item.getDescription());
			newIngredient.setIncluded(item.isIncluded());
			newIngredient.setPrice(item.getPrice());

			listIngredients.add(newIngredient);
		}

		MenuItem result = menuItemService.edit(id, request.getMenuCategory(), request.getName(), request.getDescription(), request.getPrice(), MenuItemStatusEnum.get(request.getStatus()),
				listIngredients);

		MenuItemResponse response = new MenuItemResponse();

		response.setId(result.getId());
		response.setName(result.getName());
		response.setMenuCategory(result.getMenuCategory().getId());
		response.setMenuCategoryName(result.getMenuCategory().getName());
		response.setDescription(result.getDescription());
		response.setStatus(result.getStatus().ordinal());
		response.setStatusDescription(result.getStatus().name());
		response.setPrice(result.getPrice());

		return response;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Long id) {
		menuItemService.delete(id);
	}

	@GetMapping("/to-order")
	public List<MenuItemResponse> listActiveItems() {
		List<MenuItem> result = menuItemService.listAll(MenuItemStatusEnum.ENABLED);
		List<MenuItemResponse> response = new ArrayList<>();

		for (MenuItem menuItem : result) {
			MenuItemResponse item = new MenuItemResponse();

			item.setId(menuItem.getId());
			item.setName(menuItem.getName());
			item.setMenuCategory(menuItem.getMenuCategory().getId());
			item.setMenuCategoryName(menuItem.getMenuCategory().getName());
			item.setDescription(menuItem.getDescription());
			item.setStatus(menuItem.getStatus().ordinal());
			item.setStatusDescription(menuItem.getStatus().name());
			item.setPrice(menuItem.getPrice());

			response.add(item);
		}

		return response;
	}

}
