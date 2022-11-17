package com.potatorestaurant.single.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.model.MenuCategory;
import com.potatorestaurant.single.domain.repository.IMenuCategoryRepository;

@Service
public class MenuCategoryService {

	@Autowired
	IMenuCategoryRepository menuCategoryRepository;

	public List<MenuCategory> listAll() {
		return menuCategoryRepository.findAll();
	}

	public MenuCategory getById(Long id) {
		return menuCategoryRepository.findById(id).get();
	}

	public MenuCategory create(MenuCategory newCategory) {
		return menuCategoryRepository.save(newCategory);
	}

	public MenuCategory edit(Long id, MenuCategory editCategory) {
		MenuCategory category = menuCategoryRepository.findById(id).orElseThrow();
		ModelMapperUtils.map(editCategory, category);
		return menuCategoryRepository.save(category);
	}

	public void delete(Long id) {
		MenuCategory category = menuCategoryRepository.findById(id).orElseThrow();
		menuCategoryRepository.delete(category);
	}

}
