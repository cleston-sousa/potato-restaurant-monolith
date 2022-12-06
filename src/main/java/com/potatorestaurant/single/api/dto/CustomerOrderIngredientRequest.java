package com.potatorestaurant.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Ingredient model request", description = "Request object representing a ingredient")
public class CustomerOrderIngredientRequest {

	@ApiModelProperty(name = "Ingredient action", example = "REMOVE,ADD")
	private String action;

	@ApiModelProperty(name = "Ingredient id", example = "1")
	private Long ingredientId;

}
