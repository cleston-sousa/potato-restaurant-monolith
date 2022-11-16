package com.potatorestaurant.single.domain.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public MenuCategory create(String name) {
		MenuCategory newCategory = new MenuCategory();
		if (StringUtils.isNotBlank(name))
			newCategory.setName(name);
		return menuCategoryRepository.save(newCategory);

	}

	public MenuCategory edit(Long id, String name) {
		MenuCategory category = menuCategoryRepository.findById(id)
				.orElseThrow();
		if (StringUtils.isNotBlank(name))
			category.setName(name);
		return menuCategoryRepository.save(category);
	}

	public void delete(Long id) {
		MenuCategory category = menuCategoryRepository.findById(id)
				.orElseThrow();
		menuCategoryRepository.delete(category);
	}

}
