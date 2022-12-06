package com.potatorestaurant.single.domain.enums;

public enum CustomIngredientActionEnum {
	REMOVE, ADD;

	public static CustomIngredientActionEnum get(int ordinal) {
		for (CustomIngredientActionEnum item : CustomIngredientActionEnum.values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
