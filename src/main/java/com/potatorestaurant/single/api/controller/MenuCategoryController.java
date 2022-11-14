package com.potatorestaurant.single.api.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potatorestaurant.single.api.dto.MenuCategoryResponse;

@RestController
@RequestMapping("/menu-categories")
public class MenuCategoryController {

	@GetMapping
	public List<MenuCategoryResponse> listAll() {
		return Collections.emptyList();
	}

	@PostMapping("/{id}")
	public MenuCategoryResponse addCategory() {
		return new MenuCategoryResponse();
	}

	@PatchMapping("/{id}")
	public MenuCategoryResponse editCategory() {
		return new MenuCategoryResponse();
	}

	@DeleteMapping("/{id}")
	public void deleteCategory() {
	}

	@GetMapping("/to-order")
	public List<MenuCategoryResponse> listActiveItems() {
		return Collections.emptyList();
	}

}
