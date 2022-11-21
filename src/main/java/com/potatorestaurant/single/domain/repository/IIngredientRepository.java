package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.potatorestaurant.single.domain.model.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {
	
	@Modifying
	@Query("delete from Ingredient where menuItem.id = :menuItemId")
	void deleteByMenuItemId(Long menuItemId);
}
