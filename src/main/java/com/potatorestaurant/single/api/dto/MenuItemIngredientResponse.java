package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Ingredients response", description = "Response object representing a ingredient")
public class MenuItemIngredientResponse {

	@ApiModelProperty(name = "Ingredient id", example = "1")
	private Long id;

	@ApiModelProperty(name = "Ingredient name", example = "Tomato")
	private String name;

	@ApiModelProperty(name = "Ingredient description", example = "A rare fruit from earth")
	private String description;

	@ApiModelProperty(name = "Ingredient included as part of menu item", example = "true")
	private boolean included;

	@ApiModelProperty(name = "Ingredient price if it is not included", example = "0.99")
	private BigDecimal price;

}
