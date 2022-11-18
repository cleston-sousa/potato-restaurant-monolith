package com.potatorestaurant.single.api.controller.openapi;

import java.util.List;

import com.potatorestaurant.single.api.dto.MenuCategoryCreateRequest;
import com.potatorestaurant.single.api.dto.MenuCategoryEditRequest;
import com.potatorestaurant.single.api.dto.MenuCategoryResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Menu categories", description = "Manage menu categories")
public interface MenuCategoryControllerOpenApi {

	@ApiOperation(value = "List all menu categories")
	List<MenuCategoryResponse> listAll();

	@ApiOperation(value = "Create a menu category")
	@ApiResponses({ @ApiResponse(code = 201, message = "Menu category successfully created"), })
	MenuCategoryResponse addCategory(@ApiParam(name = "request", value = "New menu category model") MenuCategoryCreateRequest request);

	@ApiOperation(value = "Edit a menu category")
	MenuCategoryResponse editCategory(@ApiParam(value = "Menu category id", example = "1", required = true) Long id,
			@ApiParam(name = "request", value = "Edit menu category model") MenuCategoryEditRequest request);

	@ApiOperation(value = "Delete a menu category")
	void deleteCategory(Long id);

}