package com.potatorestaurant.single.api.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Customer order model response", description = "Response object representing a customer order")
public class CustomerOrderResponse {

	@ApiModelProperty(name = "Customer order id", example = "1")
	private Long id;

	@ApiModelProperty(name = "Customer order name", example = "Ribs on the Barbie")
	private Long customerTableId;

	private String customerTableName;

	private Long menuItemId;

	private String menuItemName;

	private Integer quantity;

	@ApiModelProperty(name = "Customer order status id", example = "0")
	private Integer status;

	@ApiModelProperty(name = "Customer order status", example = "0")
	private String statusDescription;

	@ApiModelProperty(name = "Customer order creation date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime createdAt;

	@ApiModelProperty(name = "Customer order last update date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime updatedAt;

	@ApiModelProperty(name = "List of additional ingredients to current order")
	List<CustomerOrderIngredientResponse> addIngredient = new ArrayList<>();

	@ApiModelProperty(name = "List of removed ingredients from current order")
	List<CustomerOrderIngredientResponse> removeIngredient = new ArrayList<>();

}
