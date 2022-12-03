package com.potatorestaurant.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Order edit request", description = "Request body content to edit a order")
public class CustomerOrderEditRequest {

	@ApiModelProperty(name = "Customer table id", example = "1")
	private Long customerTableId;

	@ApiModelProperty(name = "Menu item id", example = "1")
	private Long menuItemId;

	@ApiModelProperty(name = "Quantity", example = "2")
	private Integer quantity;
}
