package com.potatorestaurant.single.domain.enums;

public enum CustomerOrderStatusEnum {
	AWAITING, DELIVERED, CANCELLED;

	public static CustomerOrderStatusEnum get(int ordinal) {
		for (CustomerOrderStatusEnum item : CustomerOrderStatusEnum.values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
