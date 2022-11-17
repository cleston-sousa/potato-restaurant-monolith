package com.potatorestaurant.single.api.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class CustomerTableResponse {

	private Long id;

	private String name;

	private Integer status;

	private OffsetDateTime createdAt;

	private OffsetDateTime updatedAt;

}
