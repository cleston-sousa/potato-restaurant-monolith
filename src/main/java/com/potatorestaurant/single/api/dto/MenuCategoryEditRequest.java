package com.potatorestaurant.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Menu category edit request", description = "Request body content to edit a menu category")
public class MenuCategoryEditRequest {

	@ApiModelProperty(name = "Menu category name", example = "Drinks")
	private String name;

}
