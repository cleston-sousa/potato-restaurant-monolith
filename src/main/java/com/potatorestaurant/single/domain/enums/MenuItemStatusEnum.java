package com.potatorestaurant.single.domain.enums;

public enum MenuItemStatusEnum {
	DISABLED, ENABLED;

	public static MenuItemStatusEnum get(int ordinal) {
		for (MenuItemStatusEnum item : MenuItemStatusEnum.values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
