package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Menu item edit request", description = "Request body content to edit a menu item")
public class MenuItemEditRequest {

	@ApiModelProperty(name = "Menu item name", example = "Ribs on the Barbie")
	private String name;

	@ApiModelProperty(name = "Menu item category id", example = "1")
	private Long menuCategoryId;

	@ApiModelProperty(name = "Menu item description", example = "Delicious barbecue ribs with tomatoes")
	private String description;

	@ApiModelProperty(name = "Menu item price", example = "135.81")
	private BigDecimal price;

	@ApiModelProperty(name = "Menu item status", example = "0")
	private Integer status;

	@ApiModelProperty(name = "Menu item ingredients")
	private List<MenuItemIngredientRequest> ingredients = new ArrayList<>();

}
