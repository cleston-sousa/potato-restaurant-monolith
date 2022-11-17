package com.potatorestaurant.single.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class AddIngredient {

	@EmbeddedId
	private IngredientId ingredientId;

}
