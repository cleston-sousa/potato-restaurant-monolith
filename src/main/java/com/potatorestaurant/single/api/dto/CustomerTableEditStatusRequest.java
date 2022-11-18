package com.potatorestaurant.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Customer table edit status request", description = "Request body content to edit a customer table status")
public class CustomerTableEditStatusRequest {

	@ApiModelProperty(name = "Customer table status", example = "0", required = true)
	private Integer status;

}
