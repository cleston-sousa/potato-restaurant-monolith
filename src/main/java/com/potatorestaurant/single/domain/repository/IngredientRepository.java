package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
