package com.potatorestaurant.single.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.MenuItem;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {

	Optional<Ingredient> findByIdAndMenuItem(Long id, MenuItem menuItem);

	@Modifying
	@Query("delete from Ingredient where menuItem.id = :menuItemId")
	void deleteByMenuItemId(Long menuItemId);
}
