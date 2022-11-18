package com.potatorestaurant.single.domain.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private MenuItem menuItem;

	private String name;

	private String description;

	private boolean included;

	private BigDecimal price;

	@OneToMany(mappedBy = "ingredientId.ingredient")
	List<AddIngredient> addIngredient;

	@OneToMany(mappedBy = "ingredientId.ingredient")
	List<RemoveIngredient> removeIngredient;
}
