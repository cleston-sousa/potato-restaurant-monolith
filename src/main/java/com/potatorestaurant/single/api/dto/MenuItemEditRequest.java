package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class MenuItemEditRequest {

	private Long menuCategory;

	private String name;

	private String description;

	private BigDecimal price;

	private Integer status;

	private List<MenuItemIngredientRequest> listIngredients;

}
