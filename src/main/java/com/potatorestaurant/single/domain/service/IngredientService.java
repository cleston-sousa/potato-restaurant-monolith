package com.potatorestaurant.single.domain.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.MenuItem;
import com.potatorestaurant.single.domain.repository.IIngredientRepository;

@Service
public class IngredientService {

	@Autowired
	IIngredientRepository ingredientRepository;

	public Ingredient create(MenuItem menuItem, String name, String description, boolean included, BigDecimal price) {

		Ingredient newIngredient = new Ingredient();

		newIngredient.setMenuItem(menuItem);
		newIngredient.setName(name);
		newIngredient.setDescription(description);
		newIngredient.setIncluded(included);
		newIngredient.setPrice(price);

		return ingredientRepository.save(newIngredient);

	}

	public void deleteAll(MenuItem menuItem) {
		if (menuItem != null)
			ingredientRepository.deleteAllByMenuItem(menuItem);
	}

}
