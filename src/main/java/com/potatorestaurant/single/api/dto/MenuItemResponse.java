package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Menu item model response", description = "Response object representing a menu item")
public class MenuItemResponse {

	@ApiModelProperty(name = "Menu item id", example = "1")
	private Long id;

	@ApiModelProperty(name = "Menu item name", example = "Ribs on the Barbie")
	private String name;

	@ApiModelProperty(name = "Menu item category id", example = "1")
	private Long menuCategoryId;

	@ApiModelProperty(name = "Menu item description", example = "Delicious barbecue ribs with tomatoes")
	private String description;

	@ApiModelProperty(name = "Menu item status", example = "0")
	private Integer status;

	@ApiModelProperty(name = "Menu item price", example = "135.81")
	private BigDecimal price;

	@ApiModelProperty(name = "Menu item creation date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime createdAt;

	@ApiModelProperty(name = "Menu item last update date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime updatedAt;

	@ApiModelProperty(name = "Menu item ingredients")
	private List<MenuItemIngredientResponse> ingredients = new ArrayList<>();

}
