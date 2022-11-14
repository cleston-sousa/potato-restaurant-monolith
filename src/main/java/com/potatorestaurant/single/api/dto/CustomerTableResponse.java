package com.potatorestaurant.single.api.dto;

import lombok.Data;

@Data
public class CustomerTableResponse {

	private Long id;

	private String name;

	private Integer status;

	private String statusDescription;

}
