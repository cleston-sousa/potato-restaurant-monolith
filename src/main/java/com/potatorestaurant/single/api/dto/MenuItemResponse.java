package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MenuItemResponse {

	private Long id;

	private String name;

	private Long menuCategory;

	private String menuCategoryName;

	private String description;

	private Integer status;

	private String statusDescription;

	private BigDecimal price;

	private List<MenuItemIngredientRequest> ingredients = new ArrayList<>();

}
