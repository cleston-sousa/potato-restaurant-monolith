package com.potatorestaurant.single.api.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Menu item add ingredients request", description = "Request body content to add ingredients to a menu item")
public class MenuItemAddIngredientRequest {

	@ApiModelProperty(name = "Menu item ingredients")
	private List<MenuItemIngredientRequest> ingredients = new ArrayList<>();

}
