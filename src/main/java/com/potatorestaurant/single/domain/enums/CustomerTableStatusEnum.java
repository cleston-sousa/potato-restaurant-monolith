package com.potatorestaurant.single.domain.enums;

public enum CustomerTableStatusEnum {
	AVAILABLE, OCCUPIED, PAYMENT;

	public static CustomerTableStatusEnum get(int ordinal) {
		for (CustomerTableStatusEnum item : CustomerTableStatusEnum.values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
