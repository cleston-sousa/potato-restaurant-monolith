package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Ingredient model response", description = "Response object representing a ingredient")
public class CustomerOrderIngredientResponse {

	@ApiModelProperty(name = "Ingredient id", example = "1")
	private Long id;

	@ApiModelProperty(name = "Ingredient name", example = "Tomato")
	private String name;

	@ApiModelProperty(name = "Ingredient price", example = "2.0")
	private BigDecimal price;
}
