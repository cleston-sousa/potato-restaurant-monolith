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

import com.potatorestaurant.single.api.dto.MenuCategoryCreateRequest;
import com.potatorestaurant.single.api.dto.MenuCategoryEditRequest;
import com.potatorestaurant.single.api.dto.MenuCategoryResponse;
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
		List<MenuCategoryResponse> response = new ArrayList<>();

		for (MenuCategory menuCategory : result) {
			MenuCategoryResponse item = new MenuCategoryResponse();

			item.setId(menuCategory.getId());
			item.setName(menuCategory.getName());

			response.add(item);
		}

		return response;
	}

	@PostMapping("/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MenuCategoryResponse addCategory(@RequestBody MenuCategoryCreateRequest request) {

		menuCategoryService.create(request.getName());

		return new MenuCategoryResponse();
	}

	@PatchMapping("/{id}")
	public MenuCategoryResponse editCategory(@PathVariable Long id, @RequestBody MenuCategoryEditRequest request) {

		MenuCategory result = menuCategoryService.edit(id, request.getName());

		MenuCategoryResponse response = new MenuCategoryResponse();

		response.setId(result.getId());
		response.setName(result.getName());

		return response;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Long id) {
		menuCategoryService.delete(id);
	}

}
