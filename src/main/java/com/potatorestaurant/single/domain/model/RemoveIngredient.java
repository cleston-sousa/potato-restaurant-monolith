package com.potatorestaurant.single.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class RemoveIngredient {

	@ManyToOne
	private CustomerOrder customerOrder;

	@ManyToOne
	private Ingredient ingredient;

}
