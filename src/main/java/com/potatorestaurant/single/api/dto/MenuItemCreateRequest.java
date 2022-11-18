package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Menu item create request", description = "Request body content to create a menu item")
public class MenuItemCreateRequest {

	@ApiModelProperty(name = "Menu item name", example = "Ribs on the Barbie")
	private String name;

	@ApiModelProperty(name = "Menu item category id", example = "1")
	private Long menuCategoryId;

	@ApiModelProperty(name = "Menu item description", example = "Delicious barbecue ribs with tomatoes")
	private String description;

	@ApiModelProperty(name = "Menu item price", example = "135.81")
	private BigDecimal price;

	@ApiModelProperty(name = "Menu item status", example = "1")
	private Integer status;

}
