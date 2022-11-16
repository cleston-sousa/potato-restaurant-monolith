package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MenuItemIngredientRequest {

	private Long id;

	private String name;

	private String description;

	private boolean included;

	private BigDecimal price;
}