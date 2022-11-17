package com.potatorestaurant.single.api.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class MenuItemCreateRequest {

	Long menuCategory;
	
	String name;
	
	String description;
	
	BigDecimal price;
	
	List<MenuItemIngredientRequest> listIngredients;

}
