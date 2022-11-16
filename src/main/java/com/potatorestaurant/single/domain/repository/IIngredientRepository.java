package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.MenuItem;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {

	void deleteAllByMenuItem(MenuItem menuItem);
}
