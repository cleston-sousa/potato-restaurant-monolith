package com.potatorestaurant.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Menu category create request", description = "Request body content to create a menu category")
public class MenuCategoryCreateRequest {

	@ApiModelProperty(name = "Menu category name", example = "Drinks")
	private String name;

}
