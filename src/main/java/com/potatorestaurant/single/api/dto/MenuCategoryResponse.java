package com.potatorestaurant.single.api.dto;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Menu category model response", description = "Response object representing a menu category")
public class MenuCategoryResponse {

	@ApiModelProperty(name = "Menu category id", example = "1")
	private Long id;

	@ApiModelProperty(name = "Menu category name", example = "Drinks")
	private String name;

	@ApiModelProperty(name = "Menu category creation date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime createdAt;

	@ApiModelProperty(name = "Menu category last update date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime updatedAt;

}
