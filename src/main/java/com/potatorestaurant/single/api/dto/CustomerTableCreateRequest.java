package com.potatorestaurant.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Customer table create request", description = "Request body content to create a customer table")
public class CustomerTableCreateRequest {

	@ApiModelProperty(name = "Customer table name", example = "Table 01", required = true)
	private String name;

}
