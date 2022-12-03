package com.potatorestaurant.single.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class IngredientId implements Serializable {

	private static final long serialVersionUID = 502998436271580225L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_order_id")
	private CustomerOrder customerOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;

}
