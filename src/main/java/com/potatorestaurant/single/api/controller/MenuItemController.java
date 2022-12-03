package com.potatorestaurant.single.api.controller;

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

import com.potatorestaurant.single.api.controller.openapi.MenuItemControllerOpenApi;
import com.potatorestaurant.single.api.dto.MenuItemAddIngredientRequest;
import com.potatorestaurant.single.api.dto.MenuItemCreateRequest;
import com.potatorestaurant.single.api.dto.MenuItemEditRequest;
import com.potatorestaurant.single.api.dto.MenuItemIngredientRequest;
import com.potatorestaurant.single.api.dto.MenuItemIngredientResponse;
import com.potatorestaurant.single.api.dto.MenuItemResponse;
import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.enums.MenuItemStatusEnum;
import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.MenuItem;
import com.potatorestaurant.single.domain.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController implements MenuItemControllerOpenApi {

	@Autowired
	MenuItemService menuItemService;

	@GetMapping
	public List<MenuItemResponse> listAll() {
		List<MenuItem> result = menuItemService.listAll(null);
		List<MenuItemResponse> response = ModelMapperUtils.mapList(result, MenuItemResponse.class);
		return response;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MenuItemResponse addMenuItem(@RequestBody MenuItemCreateRequest request) {
		MenuItem newMenuItem = ModelMapperUtils.map(request, MenuItem.class);
		MenuItem result = menuItemService.create(newMenuItem);
		MenuItemResponse response = ModelMapperUtils.map(result, MenuItemResponse.class);
		return response;
	}

	@PatchMapping("/{id}")
	public MenuItemResponse editMenuItem(@PathVariable Long id, @RequestBody MenuItemEditRequest request) {
		MenuItem editMenuItem = ModelMapperUtils.map(request, MenuItem.class);
		MenuItem result = menuItemService.edit(id, editMenuItem);
		MenuItemResponse response = ModelMapperUtils.map(result, MenuItemResponse.class);
		return response;
	}

	@PostMapping("/ingredients/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MenuItemIngredientResponse addMenuItemIngredient(@PathVariable Long id, @RequestBody MenuItemIngredientRequest request) {
		Ingredient newIngredient= ModelMapperUtils.map(request, Ingredient.class);
		Ingredient result = menuItemService.addIngredientToMenuItem(id, newIngredient);
		MenuItemIngredientResponse response = ModelMapperUtils.map(result, MenuItemIngredientResponse.class);
		return response;
	}

	@PatchMapping("/ingredients/{id}")
	public List<MenuItemIngredientResponse> editMenuItemIngredients(@PathVariable Long id, @RequestBody MenuItemAddIngredientRequest request) {
		List<Ingredient> newIngredients=  ModelMapperUtils.mapList(request.getIngredients(), Ingredient.class);
		List<Ingredient> result = menuItemService.editIngredientsFromMenuItem(id, newIngredients);
		List<MenuItemIngredientResponse> response = ModelMapperUtils.mapList(result, MenuItemIngredientResponse.class);
		return response;
	}


	@DeleteMapping("/ingredients/{ingredientId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeMenuItemIngredient(@PathVariable Long ingredientId) {
		menuItemService.removeIngredientFromMenuItem(ingredientId);
	}

	@DeleteMapping("/ingredients/all/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeMenuItemIngredients(@PathVariable Long id) {
		menuItemService.removeAllIngredientsFromMenuItem(id);
	}
	
	@Override
	public void deleteMenuItem(Long id) {
		menuItemService.delete(id);
	}

	@Override
	public List<MenuItemResponse> listActiveMenuItems() {
		List<MenuItem> result = menuItemService.listAll(MenuItemStatusEnum.ENABLED);
		List<MenuItemResponse> response = ModelMapperUtils.mapList(result, MenuItemResponse.class);
		return response;
	}
}
