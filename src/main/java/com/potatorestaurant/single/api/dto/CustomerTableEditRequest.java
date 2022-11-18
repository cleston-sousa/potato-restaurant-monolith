package com.potatorestaurant.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Customer table edit request", description = "Request body content to edit a customer table")
public class CustomerTableEditRequest {

	@ApiModelProperty(name = "Customer table name", example = "Table 01")
	private String name;

	@ApiModelProperty(name = "Customer table status", example = "0")
	private Integer status;

}
