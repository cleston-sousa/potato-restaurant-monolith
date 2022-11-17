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

import com.potatorestaurant.single.api.dto.MenuCategoryCreateRequest;
import com.potatorestaurant.single.api.dto.MenuCategoryEditRequest;
import com.potatorestaurant.single.api.dto.MenuCategoryResponse;
import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.model.MenuCategory;
import com.potatorestaurant.single.domain.service.MenuCategoryService;

@RestController
@RequestMapping("/menu-categories")
public class MenuCategoryController {

	@Autowired
	MenuCategoryService menuCategoryService;

	@GetMapping
	public List<MenuCategoryResponse> listAll() {
		List<MenuCategory> result = menuCategoryService.listAll();
		List<MenuCategoryResponse> response = ModelMapperUtils.mapList(result, MenuCategoryResponse.class);
		return response;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MenuCategoryResponse addCategory(@RequestBody MenuCategoryCreateRequest request) {
		MenuCategory toCreate = ModelMapperUtils.map(request, MenuCategory.class);
		MenuCategory result = menuCategoryService.create(toCreate);
		MenuCategoryResponse response = ModelMapperUtils.map(result, MenuCategoryResponse.class);
		return response;
	}

	@PatchMapping("/{id}")
	public MenuCategoryResponse editCategory(@PathVariable Long id, @RequestBody MenuCategoryEditRequest request) {
		MenuCategory toEdit = ModelMapperUtils.map(request, MenuCategory.class);
		MenuCategory result = menuCategoryService.edit(id, toEdit);
		MenuCategoryResponse response = ModelMapperUtils.map(result, MenuCategoryResponse.class);
		return response;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Long id) {
		menuCategoryService.delete(id);
	}

}
