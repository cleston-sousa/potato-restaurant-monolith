package com.potatorestaurant.single.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class RemoveIngredient {

	@EmbeddedId
	private IngredientId ingredientId;
}
