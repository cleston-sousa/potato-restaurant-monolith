package com.potatorestaurant.single.api.controller.openapi;

import java.util.List;

import com.potatorestaurant.single.api.dto.MenuItemAddIngredientRequest;
import com.potatorestaurant.single.api.dto.MenuItemCreateRequest;
import com.potatorestaurant.single.api.dto.MenuItemEditRequest;
import com.potatorestaurant.single.api.dto.MenuItemIngredientRequest;
import com.potatorestaurant.single.api.dto.MenuItemIngredientResponse;
import com.potatorestaurant.single.api.dto.MenuItemResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Menu items", description = "Manage menu items")
public interface MenuItemControllerOpenApi {

	@ApiOperation(value = "List all menu items")
	List<MenuItemResponse> listAll();

	@ApiOperation(value = "Create a menu item")
	@ApiResponses({ @ApiResponse(code = 201, message = "Menu item successfully created"), })
	MenuItemResponse addMenuItem(@ApiParam(name = "request", value = "New menu item model") MenuItemCreateRequest request);

	@ApiOperation(value = "Edit a menu item")
	MenuItemResponse editMenuItem(@ApiParam(value = "Menu item id", example = "1", required = true) Long id,
			@ApiParam(name = "request", value = "Edit menu item model") MenuItemEditRequest request);

	@ApiOperation(value = "Add a ingredient in a menu item")
	public MenuItemIngredientResponse addMenuItemIngredient(@ApiParam(value = "Menu item id", example = "1", required = true) Long id,
			@ApiParam(name = "request", value = "New ingredient model") MenuItemIngredientRequest request);

	@ApiOperation(value = "Edit a list of ingredients in a menu item")
	public List<MenuItemIngredientResponse> editMenuItemIngredients(@ApiParam(value = "Menu item id", example = "1", required = true) Long id,
			@ApiParam(name = "request", value = "Edit list of ingredients model") MenuItemAddIngredientRequest request);

	@ApiOperation(value = "Remove all ingredients in a menu item")
	public void removeMenuItemIngredients(@ApiParam(value = "Menu item id", example = "1", required = true) Long id);

	@ApiOperation(value = "Remove a ingredient in a menu item")
	public void removeMenuItemIngredient(@ApiParam(value = "Menu item id", example = "1", required = true) Long ingredientId);

	@ApiOperation(value = "Remove a menu item")
	void deleteMenuItem(Long id);

	@ApiOperation(value = "List all menu items available to be consumed")
	List<MenuItemResponse> listActiveMenuItems();

}