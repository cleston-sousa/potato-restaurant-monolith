package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Ingredients request", description = "Request object representing a ingredient")
public class MenuItemIngredientRequest {

	@ApiModelProperty(name = "Ingredient name", example = "Tomato")
	private String name;

	@ApiModelProperty(name = "Ingredient description", example = "A rare fruit from earth")
	private String description;

	@ApiModelProperty(name = "Ingredient included as part of menu item", example = "true")
	private boolean included;

	@ApiModelProperty(name = "Ingredient price if it is not included", example = "0.99")
	private BigDecimal price;

}
