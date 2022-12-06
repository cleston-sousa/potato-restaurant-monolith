package com.potatorestaurant.single.api.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Customer order create request", description = "Request body content to create a customer order")
public class CustomerOrderCreateRequest {

	@ApiModelProperty(name = "Customer table id", example = "1")
	private Long customerTableId;

	@ApiModelProperty(name = "Menu item id", example = "1")
	private Long menuItemId;

	@ApiModelProperty(name = "Quantity", example = "2")
	private Integer quantity;

	@ApiModelProperty(name = "List of ingredients IDs as additional items to current order")
	List<CustomerOrderIngredientRequest> customIngredient = new ArrayList<>();

}
