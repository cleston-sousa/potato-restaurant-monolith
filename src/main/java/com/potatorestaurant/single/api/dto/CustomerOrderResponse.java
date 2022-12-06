package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;
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

	@ApiModelProperty(name = "Customer order table name", example = "Table 01")
	private String customerTableName;

	@ApiModelProperty(name = "Customer order menu item name", example = "Ribs on the Barbie")
	private String menuItemName;

	@ApiModelProperty(name = "Customer order menu item quantity", example = "3")
	private Integer quantity;

	@ApiModelProperty(name = "Customer order status id", example = "0")
	private Integer status;

	@ApiModelProperty(name = "Customer order price", example = "10.50")
	private BigDecimal price;

	@ApiModelProperty(name = "Customer order creation date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime createdAt;

	@ApiModelProperty(name = "Customer order last update date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime updatedAt;

	@ApiModelProperty(name = "List of custom ingredients to current order")
	List<CustomerOrderIngredientResponse> customIngredient = new ArrayList<>();

}
