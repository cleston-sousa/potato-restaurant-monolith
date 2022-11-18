package com.potatorestaurant.single.api.dto;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Customer table model response", description = "Response object representing a customer table")
public class CustomerTableResponse {

	@ApiModelProperty(name = "Customer table id", example = "1")
	private Long id;

	@ApiModelProperty(name = "Customer table name", example = "Table 01")
	private String name;

	@ApiModelProperty(name = "Customer table status", example = "0")
	private Integer status;

	@ApiModelProperty(name = "Customer table creation date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime createdAt;

	@ApiModelProperty(name = "Customer table last update date", example = "YYYY-MM-DDTHH:mm:ss.sssZ")
	private OffsetDateTime updatedAt;

}
