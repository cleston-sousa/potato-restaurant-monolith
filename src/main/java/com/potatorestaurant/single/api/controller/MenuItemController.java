package com.potatorestaurant.single.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.potatorestaurant.single.api.dto.MenuItemResponse;
import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
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

	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MenuItemResponse addMenuItem(@RequestBody MenuItemCreateRequest request) {
		MenuItem newMenuItem = ModelMapperUtils.map(request, MenuItem.class);
		MenuItem result = menuItemService.create(newMenuItem);
		MenuItemResponse response = ModelMapperUtils.map(result, MenuItemResponse.class);
		return response;
	}

	@PostMapping("/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MenuItemResponse addMenuItemIngredients(@RequestBody MenuItemAddIngredientRequest request) {
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
/*
	@PatchMapping("/{id}")
	public MenuItemResponse editMenuItem(@PathVariable Long id, @RequestBody MenuItemEditRequest request) {

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
		response.setDescription(result.getDescription());
		response.setStatus(result.getStatus().ordinal());
		response.setPrice(result.getPrice());

		return response;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMenuItem(@PathVariable Long id) {
		menuItemService.delete(id);
	}

	@GetMapping("/to-order")
	public List<MenuItemResponse> listActiveMenuItems() {
		List<MenuItem> result = menuItemService.listAll(MenuItemStatusEnum.ENABLED);
		List<MenuItemResponse> response = new ArrayList<>();

		for (MenuItem menuItem : result) {
			MenuItemResponse item = new MenuItemResponse();

			item.setId(menuItem.getId());
			item.setName(menuItem.getName());
			item.setMenuCategory(menuItem.getMenuCategory().getId());
			item.setDescription(menuItem.getDescription());
			item.setStatus(menuItem.getStatus().ordinal());
			item.setPrice(menuItem.getPrice());

			response.add(item);
		}

		return response;
	}
*/

	@Override
	public void deleteMenuItem(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MenuItemResponse> listActiveMenuItems() {
		// TODO Auto-generated method stub
		return null;
	}
}
